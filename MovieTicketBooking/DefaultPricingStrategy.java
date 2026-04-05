package MovieTicketBooking;

public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double computePrice(Show show, Seat seat) {
        return 200.0;
    }
}