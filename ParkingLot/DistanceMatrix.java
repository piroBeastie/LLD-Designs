package ParkingLot;

import java.util.*;

class DistanceMatrix {
    Map<Gate, Map<ParkingSpot, Integer>> distanceMap = new HashMap<>();

    void addDistance(Gate gate, ParkingSpot spot, int distance) {
        distanceMap
            .computeIfAbsent(gate, k -> new HashMap<>())
            .put(spot, distance);
    }

    int getDistance(Gate gate, ParkingSpot spot) {
        return distanceMap.getOrDefault(gate, new HashMap<>())
                          .getOrDefault(spot, Integer.MAX_VALUE);
    }
}