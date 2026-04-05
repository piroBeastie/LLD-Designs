package DistributedCache;

import java.util.concurrent.*;

public class RequestCollapser<K, V> {

    private final ConcurrentHashMap<K, CompletableFuture<V>> activeRequests =
            new ConcurrentHashMap<>();

    public CompletableFuture<V> getOrCreate(K key) {
        return activeRequests.computeIfAbsent(key, k -> new CompletableFuture<>());
    }

    public void complete(K key, V value) {

        CompletableFuture<V> future = activeRequests.get(key);

        if (future != null) {
            future.complete(value);
            activeRequests.remove(key);
        }
    }
}
