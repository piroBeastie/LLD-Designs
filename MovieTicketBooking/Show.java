package MovieTicketBooking;

import java.util.*;

public class Show {

    private String showId;
    private Movie movieRef;
    private Screen screenRef;
    private Map<Seat, SeatStatus> seatState;

    public Show(String id, Movie movie, Screen screen) {
        this.showId = id;
        this.movieRef = movie;
        this.screenRef = screen;
        this.seatState = new HashMap<>();

        for (Seat s : screen.getSeats()) {
            seatState.put(s, SeatStatus.AVAILABLE);
        }
    }

    public Map<Seat, SeatStatus> getSeatState() {
        return seatState;
    }

    public String getShowId() {
        return showId;
    }
}