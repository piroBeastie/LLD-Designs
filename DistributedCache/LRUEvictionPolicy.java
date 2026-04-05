package DistributedCache;

import java.util.*;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private class Node {
        K key;
        Node prev, next;

        Node(K key) {
            this.key = key;
        }
    }

    private final Map<K, Node> nodeMap = new HashMap<>();
    private final Node head;
    private final Node tail;

    public LRUEvictionPolicy() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void keyAccessed(K key) {

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            detach(node);
            insertAtEnd(node);
        } else {
            Node node = new Node(key);
            nodeMap.put(key, node);
            insertAtEnd(node);
        }
    }

    @Override
    public K evictKey() {

        Node leastUsed = head.next;
        detach(leastUsed);
        nodeMap.remove(leastUsed.key);

        return leastUsed.key;
    }

    private void detach(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtEnd(Node node) {

        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
}