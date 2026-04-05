package MovieTicketBooking;

public class PaymentService {

    public Payment processPayment(Booking booking, double amount) {
        Payment payment = new Payment(booking, amount);
        payment.markSuccess();
        return payment;
    }
}
