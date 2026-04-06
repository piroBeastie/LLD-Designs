package ParkingLot;

abstract class Gate {
    int gateId;
    GateType type;

    Gate(int id, GateType type) {
        this.gateId = id;
        this.type = type;
    }
}
