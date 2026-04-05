package MovieTicketBooking;

public class Seat {

    private String seatId;
    private int rowNumber;
    private int columnNumber;

    public Seat(String id, int row, int col) {
        this.seatId = id;
        this.rowNumber = row;
        this.columnNumber = col;
    }

    public String getSeatId() {
        return seatId;
    }

    public int getRow() {
        return rowNumber;
    }

    public int getColumn() {
        return columnNumber;
    }
}
