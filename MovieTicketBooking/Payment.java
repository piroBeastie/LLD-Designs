package MovieTicketBooking;

public class Payment {

    private Booking bookingRef;
    private double amountPaid;
    private PaymentStatus status;

    public Payment(Booking booking, double amount) {
        this.bookingRef = booking;
        this.amountPaid = amount;
        this.status = PaymentStatus.PENDING;
    }

    public void markSuccess() {
        this.status = PaymentStatus.SUCCESS;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amountPaid;
    }
}