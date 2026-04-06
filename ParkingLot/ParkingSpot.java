package ParkingLot;

abstract class ParkingSpot {
    int spotId;
    SlotType type;
    boolean isOccupied;
    Vehicle currentVehicle;

    ParkingSpot(int id, SlotType type) {
        this.spotId = id;
        this.type = type;
        this.isOccupied = false;
    }

    boolean isAvailable() {
        return !isOccupied;
    }

    void assignVehicle(Vehicle v) {
        this.currentVehicle = v;
        this.isOccupied = true;
    }

    void removeVehicle() {
        this.currentVehicle = null;
        this.isOccupied = false;
    }
}
