package DistributedCache;

public interface DataSource<K, V> {
    V get(K key);
}
