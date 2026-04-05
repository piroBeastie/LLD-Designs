package RateLimiter;

interface RemoteResource {
    String callRemote(RequestDTO request);
}