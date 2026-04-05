package MovieTicketBooking;
public interface PricingStrategy {
    double computePrice(Show show, Seat seat);
}