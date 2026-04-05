package DistributedCache;

public class CacheEntry<V> {

    private V storedValue;
    private long expirationTime;

    public CacheEntry(V value, long ttlMillis) {
        this.storedValue = value;
        this.expirationTime = System.currentTimeMillis() + ttlMillis;
    }

    public boolean hasExpired() {
        return System.currentTimeMillis() > expirationTime;
    }

    public V getValue() {
        return storedValue;
    }

    public long getExpirationTime() {
        return expirationTime;
    }
}
