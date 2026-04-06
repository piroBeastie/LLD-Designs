package ParkingLot;

import java.util.*;

class Level {
    int floorNumber;
    List<ParkingSpot> spots;

    Level(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
    }

    void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }
}
