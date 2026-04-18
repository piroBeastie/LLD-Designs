package MovieTicketBooking;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            seats.add(new Seat("S" + i, 1, i));
        }

        // Screen
        Screen screen = new Screen("Screen1", seats);

        // Movie
        Movie movie = new Movie("M1", "Inception", 150);

        // Show
        Show show = new Show("Show1", movie, screen);

        // Services
        SeatLockService lockService = new SeatLockService();
        BookingService bookingService = new BookingService(lockService);
        PricingService pricingService = new PricingService(new DefaultPricingStrategy());
        PaymentService paymentService = new PaymentService();

        // Select seats
        List<Seat> selectedSeats = Arrays.asList(seats.get(0), seats.get(1));

        // Create booking
        Booking booking = bookingService.createBooking("B1", show, selectedSeats);

        if (booking == null) {
            System.out.println("Booking failed (seat lock issue)");
            return;
        }

        // Pricing
        double total = 0;
        for (Seat s : selectedSeats) {
            total += pricingService.calculatePrice(show, s);
        }

        System.out.println("Total price: " + total);

        // Payment
        Payment payment = paymentService.processPayment(booking, total);

        if (payment.getStatus() == PaymentStatus.SUCCESS) {
            bookingService.confirmBooking(booking);
            System.out.println("Booking confirmed!");
        }
    }
}
