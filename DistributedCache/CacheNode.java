package DistributedCache;

import java.util.*;

public class CacheNode<K, V> {

    private final int maxCapacity;
    private final Map<K, CacheEntry<V>> storage;
    private final EvictionPolicy<K> evictionPolicy;

    public CacheNode(int capacity, EvictionPolicy<K> policy) {
        this.maxCapacity = capacity;
        this.storage = new HashMap<>();
        this.evictionPolicy = policy;
    }

    public synchronized V get(K key) {

        if (!storage.containsKey(key)) return null;

        CacheEntry<V> entry = storage.get(key);

        if (entry.hasExpired()) {
            System.out.println("[Node] Key " + key + " EXPIRED");
            storage.remove(key);
            return null;
        }

        evictionPolicy.keyAccessed(key);
        return entry.getValue();
    }

    public synchronized void put(K key, V value, long ttlMillis) {

        if (storage.containsKey(key)) {
            storage.put(key, new CacheEntry<>(value, ttlMillis));
            evictionPolicy.keyAccessed(key);
            return;
        }

        if (storage.size() >= maxCapacity) {
            K keyToRemove = evictionPolicy.evictKey();
            storage.remove(keyToRemove);
        }

        storage.put(key, new CacheEntry<>(value, ttlMillis));
        evictionPolicy.keyAccessed(key);
    }

    public Map<K, CacheEntry<V>> getAllEntries() {
        return new HashMap<>(storage);
    }

    public void clearAll() {
        storage.clear();
    }
}