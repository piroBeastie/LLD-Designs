package ParkingLot;

class HourlyFareStrategy implements FareStrategy {

    double ratePerHour = 20;

    public double calculateFare(Ticket ticket) {
        return ticket.getDurationInHours() * ratePerHour;
    }
}
