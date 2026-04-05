package RateLimiter;

class RLFactory {

    public static RLStrategy getStrategy(String strategyType) {

        if (strategyType.equalsIgnoreCase("FIXED")) {
            return new FixedWindowStrategy();
        } 
        else if (strategyType.equalsIgnoreCase("SLIDING")) {
            return new SlidingWindowStrategy();
        } 
        else {
            throw new IllegalArgumentException("Invalid strategy type");
        }
    }
}