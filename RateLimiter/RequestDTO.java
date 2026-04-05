package RateLimiter;

class RequestDTO {

    String userId;
    String apiKey;
    String ipAddress;
    long timestamp;

    public RequestDTO(String userId, String apiKey, String ip, long time) {
        this.userId = userId;
        this.apiKey = apiKey;
        this.ipAddress = ip;
        this.timestamp = time;
    }

    public String getKey() {
        return userId; // same logic
    }
}