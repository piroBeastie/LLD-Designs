package ParkingLot;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Level level1 = new Level(1);
        Level level2 = new Level(2);

        ParkingSpot s1 = new SmallSpot(1);
        ParkingSpot s2 = new MediumSpot(2);
        ParkingSpot s3 = new LargeSpot(3);
        ParkingSpot s4 = new MediumSpot(4);
        ParkingSpot s5 = new LargeSpot(5);

        level1.addSpot(s1);
        level1.addSpot(s2);
        level1.addSpot(s3);

        level2.addSpot(s4);
        level2.addSpot(s5);

        List<Level> levels = Arrays.asList(level1, level2);

        EntryGate gate1 = new EntryGate(101);
        EntryGate gate2 = new EntryGate(102);

        DistanceMatrix matrix = new DistanceMatrix();

        matrix.addDistance(gate1, s1, 5);
        matrix.addDistance(gate1, s2, 3);
        matrix.addDistance(gate1, s3, 7);
        matrix.addDistance(gate1, s4, 10);
        matrix.addDistance(gate1, s5, 12);

        matrix.addDistance(gate2, s1, 8);
        matrix.addDistance(gate2, s2, 6);
        matrix.addDistance(gate2, s3, 4);
        matrix.addDistance(gate2, s4, 2);
        matrix.addDistance(gate2, s5, 3);

        SlotAllocationStrategy strategy = new NearestSlotStrategy();
        FareStrategy fareStrategy = new HourlyFareStrategy();

        ParkingManager manager = new ParkingManager(levels, matrix, strategy);
        ParkingLot parkingLot = new ParkingLot(manager, fareStrategy);

        Vehicle bike = new Bike("PB10-1111");
        Vehicle car = new Car("PB10-2222");
        Vehicle truck = new Truck("PB10-3333");

        Ticket t1 = parkingLot.generateParkingTicket(bike, LocalDateTime.now(), gate1);
        Ticket t2 = parkingLot.generateParkingTicket(car, LocalDateTime.now(), gate1);
        Ticket t3 = parkingLot.generateParkingTicket(truck, LocalDateTime.now(), gate2);

        System.out.println("After Entry:");
        parkingLot.showStatus();

        LocalDateTime exitTime = LocalDateTime.now().plusHours(3);

        double bill1 = parkingLot.generateBill(t1.ticketId, exitTime);
        double bill2 = parkingLot.generateBill(t2.ticketId, exitTime);
        double bill3 = parkingLot.generateBill(t3.ticketId, exitTime);

        System.out.println("Bike Bill: " + bill1);
        System.out.println("Car Bill: " + bill2);
        System.out.println("Truck Bill: " + bill3);

        System.out.println("After Exit:");
        parkingLot.showStatus();
    }
}