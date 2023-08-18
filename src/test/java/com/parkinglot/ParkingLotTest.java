package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_parking_lot_a_car(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //When
        ParkingTicket parkingTicket = parkingLot.park(car);

        //Then
        Assertions.assertNotNull(parkingTicket);
    }
    @Test
    void should_return_the_car_when_fetch_given_parking_lot_and_a_ticket(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        //When
        Car fetchedCar = parkingLot.fetch(parkingTicket);
        //Then
        Assertions.assertEquals(car,fetchedCar);
    }
}
