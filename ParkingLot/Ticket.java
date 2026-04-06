package ParkingLot;

import java.time.*;

class Ticket {
    String ticketId;
    Vehicle vehicle;
    ParkingSpot spot;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    Gate entryGate;

    Ticket(String id, Vehicle vehicle, ParkingSpot spot,
           LocalDateTime entryTime, Gate gate) {
        this.ticketId = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
        this.entryGate = gate;
    }

    int getDurationInHours() {
        if (exitTime == null) return 0;
        return (int) Math.ceil(Duration.between(entryTime, exitTime).toHours());
    }
}
