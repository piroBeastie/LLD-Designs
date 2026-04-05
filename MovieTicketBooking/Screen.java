package MovieTicketBooking;

import java.util.*;

public class Screen {

    private String screenId;
    private List<Seat> seatList;

    public Screen(String id, List<Seat> seats) {
        this.screenId = id;
        this.seatList = seats;
    }

    public List<Seat> getSeats() {
        return seatList;
    }

    public String getScreenId() {
        return screenId;
    }
}
