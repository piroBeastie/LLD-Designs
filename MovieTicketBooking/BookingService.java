package MovieTicketBooking;

import java.util.*;

public class BookingService {

    private SeatLockService lockService;

    public BookingService(SeatLockService lockService) {
        this.lockService = lockService;
    }

    public Booking createBooking(String id, Show show, List<Seat> seats) {

        for (Seat s : seats) {
            if (!lockService.lockSeat(s)) {
                return null;
            }
        }

        return new Booking(id, show, seats);
    }

    public void confirmBooking(Booking booking) {
        booking.updateStatus(BookingStatus.CONFIRMED);
    }
}