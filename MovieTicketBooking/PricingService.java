package MovieTicketBooking;

public class PricingService {

    private PricingStrategy strategy;

    public PricingService(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(Show show, Seat seat) {
        return strategy.computePrice(show, seat);
    }
}