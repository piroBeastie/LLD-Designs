package MovieTicketBooking;
import java.util.*;

public class Booking {

    private String bookingId;
    private Show showRef;
    private List<Seat> bookedSeats;
    private BookingStatus status;

    public Booking(String id, Show show, List<Seat> seats) {
        this.bookingId = id;
        this.showRef = show;
        this.bookedSeats = seats;
        this.status = BookingStatus.PENDING;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Show getShow() {
        return showRef;
    }

    public List<Seat> getSeats() {
        return bookedSeats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void updateStatus(BookingStatus newStatus) {
        this.status = newStatus;
    }
}