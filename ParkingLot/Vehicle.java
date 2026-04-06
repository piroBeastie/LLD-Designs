package ParkingLot;

abstract class Vehicle {
    String vehicleNumber;
    VehicleType type;

    Vehicle(String number, VehicleType type) {
        this.vehicleNumber = number;
        this.type = type;
    }
}