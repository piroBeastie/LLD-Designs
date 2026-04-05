package RateLimiter;

import java.util.Queue;

interface RLStrategy {
    boolean validateRequest(Queue<RequestDTO> queue,
                            int maxAllowed,
                            RequestDTO request,
                            long windowDuration);
}