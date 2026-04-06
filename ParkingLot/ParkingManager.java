package ParkingLot;

import java.util.*;
import java.time.*;

class ParkingManager {

    List<Level> levels;
    DistanceMatrix matrix;
    SlotAllocationStrategy strategy;

    Map<String, Ticket> activeTickets = new HashMap<>();

    ParkingManager(List<Level> levels,
                   DistanceMatrix matrix,
                   SlotAllocationStrategy strategy) {
        this.levels = levels;
        this.matrix = matrix;
        this.strategy = strategy;
    }

    ParkingSpot findSpot(Vehicle vehicle, Gate gate) {
        return strategy.findSpot(vehicle, gate, levels, matrix);
    }

    Ticket generateTicket(Vehicle vehicle, LocalDateTime entryTime, Gate gate) {
        ParkingSpot spot = findSpot(vehicle, gate);

        if (spot == null) {
            System.out.println("No spot available!");
            return null;
        }

        spot.assignVehicle(vehicle);

        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle, spot, entryTime, gate);

        activeTickets.put(ticketId, ticket);
        return ticket;
    }

    double closeTicket(String ticketId, LocalDateTime exitTime, FareStrategy fareStrategy) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) return 0;

        ticket.exitTime = exitTime;

        double amount = fareStrategy.calculateFare(ticket);

        ticket.spot.removeVehicle();
        activeTickets.remove(ticketId);

        return amount;
    }
}