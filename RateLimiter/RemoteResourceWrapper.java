package RateLimiter;

class RemoteResourceWrapper implements RemoteResource {

    private RLService service;

    public RemoteResourceWrapper(RLService service) {
        this.service = service;
    }

    @Override
    public String callRemote(RequestDTO request) {

        if (!service.isAllowed(request)) {
            return "Rate Limit Exceeded";
        }

        return "External API Called";
    }
}
