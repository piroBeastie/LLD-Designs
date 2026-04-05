package RateLimiter;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int maxRequests = 3;
        long windowDuration = 5000; 

        RLStrategy strategy = RLFactory.getStrategy("SLIDING");

        RateLimiter limiter = new RateLimiter(maxRequests, windowDuration, strategy);
        RLService service = new RLService(limiter);
        RemoteResource api = new RemoteResourceWrapper(service);

        String[] users = {"user1", "user2"};

        for (int i = 1; i <= 6; i++) {

            for (String user : users) {

                RequestDTO request = new RequestDTO(
                        user,
                        "apiKey",
                        "127.0.0.1",
                        System.currentTimeMillis()
                );

                System.out.println("User: " + user + " Request " + i + ": " +
                        api.callRemote(request));
            }

            Thread.sleep(1000);
        }
    }
}