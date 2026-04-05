package MovieTicketBooking;

import java.util.*;

public class SeatLockService {

    private Map<Seat, Long> lockedSeats = new HashMap<>();
    private static final long LOCK_TIME = 5 * 60 * 1000;

    public boolean lockSeat(Seat seat) {
        long now = System.currentTimeMillis();

        if (!lockedSeats.containsKey(seat) ||
            now - lockedSeats.get(seat) > LOCK_TIME) {

            lockedSeats.put(seat, now);
            return true;
        }

        return false;
    }

    public void unlockSeat(Seat seat) {
        lockedSeats.remove(seat);
    }

    public boolean isLocked(Seat seat) {
        if (!lockedSeats.containsKey(seat)) return false;

        long now = System.currentTimeMillis();
        return now - lockedSeats.get(seat) <= LOCK_TIME;
    }
}
