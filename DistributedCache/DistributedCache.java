package DistributedCache;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class DistributedCache<K, V> {

    private final List<CacheNode<K, V>> nodeList;
    private final DistributionStrategy<K> distributionStrategy;
    private final DataSource<K, V> dataSource;
    private final RequestCollapser<K, V> requestCollapser;

    public DistributedCache(int numberOfNodes,
                            int capacityPerNode,
                            DistributionStrategy<K> strategy,
                            DataSource<K, V> db) {

        this.distributionStrategy = strategy;
        this.dataSource = db;
        this.requestCollapser = new RequestCollapser<>();
        this.nodeList = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; i++) {
            nodeList.add(new CacheNode<>(capacityPerNode, new LRUEvictionPolicy<>()));
        }
    }

    public V get(K key) {

        int nodeIndex = distributionStrategy.getNode(key, nodeList.size());
        CacheNode<K, V> node = nodeList.get(nodeIndex);

        V cachedValue = node.get(key);
        if (cachedValue != null) return cachedValue;

        CompletableFuture<V> future = requestCollapser.getOrCreate(key);

        synchronized (future) {
            if (!future.isDone()) {
                V dbValue = dataSource.get(key);
                node.put(key, dbValue, 5000);
                requestCollapser.complete(key, dbValue);
            }
        }

        try {
            return future.get();
        } catch (Exception e) {
            return null;
        }
    }

    public void put(K key, V value, long ttlMillis) {
        int nodeIndex = distributionStrategy.getNode(key, nodeList.size());
        nodeList.get(nodeIndex).put(key, value, ttlMillis);
    }

    public void addNode(CacheNode<K, V> newNode) {
        nodeList.add(newNode);
        redistributeData();
    }

    public void removeNode(int index) {

        CacheNode<K, V> removedNode = nodeList.remove(index);

        for (Map.Entry<K, CacheEntry<V>> entry : removedNode.getAllEntries().entrySet()) {
            put(entry.getKey(),
                entry.getValue().getValue(),
                entry.getValue().getExpirationTime());
        }
    }

    private void redistributeData() {

        List<Map.Entry<K, CacheEntry<V>>> allEntries = new ArrayList<>();

        for (CacheNode<K, V> node : nodeList) {
            allEntries.addAll(node.getAllEntries().entrySet());
            node.clearAll();
        }

        for (Map.Entry<K, CacheEntry<V>> entry : allEntries) {
            put(entry.getKey(),
                entry.getValue().getValue(),
                entry.getValue().getExpirationTime());
        }
    }
}