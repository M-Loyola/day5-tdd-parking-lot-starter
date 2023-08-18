package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_given_a_standard_parking_boy_and_two_parking_lots_and_a_car() {
        //Given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(9, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(10, secondParkingLot.getAvailableCapacity());
    }
}
