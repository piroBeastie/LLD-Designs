package RateLimiter;

class RLService {

    private RateLimiter limiter;

    public RLService(RateLimiter limiter) {
        this.limiter = limiter;
    }

    public boolean isAllowed(RequestDTO request) {
        return limiter.allow(request);
    }
}