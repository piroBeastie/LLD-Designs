package ParkingLot;

import java.util.List;

class NearestSlotStrategy implements SlotAllocationStrategy {

    @Override
    public ParkingSpot findSpot(Vehicle vehicle, Gate gate,
                               List<Level> levels, DistanceMatrix matrix) {

        ParkingSpot bestSpot = null;
        int minDistance = Integer.MAX_VALUE;

        for (Level level : levels) {
            for (ParkingSpot spot : level.spots) {

                if (!spot.isAvailable()) continue;

                if (!canFit(vehicle, spot)) continue;

                int dist = matrix.getDistance(gate, spot);

                if (dist < minDistance) {
                    minDistance = dist;
                    bestSpot = spot;
                }
            }
        }
        return bestSpot;
    }

    private boolean canFit(Vehicle v, ParkingSpot s) {
        if (v.type == VehicleType.BIKE) return true;
        if (v.type == VehicleType.CAR)
            return s.type == SlotType.MEDIUM || s.type == SlotType.LARGE;
        if (v.type == VehicleType.TRUCK)
            return s.type == SlotType.LARGE;
        return false;
    }
}
