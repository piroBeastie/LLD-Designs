package ParkingLot;

import java.util.List;

interface SlotAllocationStrategy {
    ParkingSpot findSpot(Vehicle vehicle, Gate gate,
                         List<Level> levels, DistanceMatrix matrix);
}
