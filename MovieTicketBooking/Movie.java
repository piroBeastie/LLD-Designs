package MovieTicketBooking;

public class Movie {

    private String movieId;
    private String movieTitle;
    private int durationMinutes;

    public Movie(String id, String title, int duration) {
        this.movieId = id;
        this.movieTitle = title;
        this.durationMinutes = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return movieTitle;
    }

    public int getDuration() {
        return durationMinutes;
    }
}