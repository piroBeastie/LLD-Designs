package RateLimiter;

import java.util.Queue;

class SlidingWindowStrategy implements RLStrategy {

    @Override
    public boolean validateRequest(Queue<RequestDTO> requestQueue,
                                   int maxAllowed,
                                   RequestDTO incomingRequest,
                                   long windowDuration) {

        long validAfter = incomingRequest.timestamp - windowDuration;

        while (!requestQueue.isEmpty() &&
               requestQueue.peek().timestamp <= validAfter) {
            requestQueue.poll();
        }

        if (requestQueue.size() < maxAllowed) {
            requestQueue.offer(incomingRequest);
            return true;
        }

        return false;
    }
}