package RateLimiter;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class RateLimiter {

    private Map<String, Queue<RequestDTO>> userRequests;
    private int maxRequests;
    private long windowDuration;
    private RLStrategy strategy;

    public RateLimiter(int maxRequests, long windowDuration, RLStrategy strategy) {
        this.userRequests = new ConcurrentHashMap<>();
        this.maxRequests = maxRequests;
        this.windowDuration = windowDuration;
        this.strategy = strategy;
    }

    public boolean allow(RequestDTO request) {

        String key = request.getKey();

        userRequests.putIfAbsent(key, new ConcurrentLinkedQueue<>());
        Queue<RequestDTO> queue = userRequests.get(key);

        return strategy.validateRequest(queue, maxRequests, request, windowDuration);
    }
}