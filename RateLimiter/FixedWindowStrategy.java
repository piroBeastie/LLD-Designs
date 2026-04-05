package RateLimiter;

import java.util.*;

class FixedWindowStrategy implements RLStrategy {

    @Override
    public boolean validateRequest(Queue<RequestDTO> requestQueue,
                                   int maxAllowed,
                                   RequestDTO incomingRequest,
                                   long windowDuration) {

        long currentWindow = incomingRequest.timestamp / windowDuration;

        while (!requestQueue.isEmpty()) {
            RequestDTO oldest = requestQueue.peek();
            long oldestWindow = oldest.timestamp / windowDuration;

            if (oldestWindow != currentWindow) {
                requestQueue.poll();
            } else {
                break;
            }
        }

        if (requestQueue.size() < maxAllowed) {
            requestQueue.offer(incomingRequest);
            return true;
        }

        return false;
    }
}