package ParkingLot;

import java.time.LocalDateTime;

class ParkingLot {

    ParkingManager manager;
    FareStrategy fareStrategy;

    ParkingLot(ParkingManager manager, FareStrategy fareStrategy) {
        this.manager = manager;
        this.fareStrategy = fareStrategy;
    }

    Ticket generateParkingTicket(Vehicle vehicle,
                                 LocalDateTime entryTime,
                                 Gate entryGate) {

        return manager.generateTicket(vehicle, entryTime, entryGate);
    }

    double generateBill(String ticketId, LocalDateTime exitTime) {
        return manager.closeTicket(ticketId, exitTime, fareStrategy);
    }

    void showStatus() {
        for (Level level : manager.levels) {
            System.out.println("Floor " + level.floorNumber);
            for (ParkingSpot spot : level.spots) {
                System.out.println("Spot " + spot.spotId +
                        " (" + spot.type + ") - " +
                        (spot.isOccupied ? "Occupied" : "Free"));
            }
        }
    }
}
