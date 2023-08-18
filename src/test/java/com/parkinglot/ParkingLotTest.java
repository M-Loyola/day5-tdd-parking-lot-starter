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

    @Test
    void should_return_two_tickets_when_fetch_car_twice_given_parking_lot_two_parked_cars_two_parking_tickets(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket ticket1 = parkingLot.park(car1);
        ParkingTicket ticket2 = parkingLot.park(car2);

        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);

        //Then
        Assertions.assertEquals(car1,fetchedCar1);
        Assertions.assertEquals(car2,fetchedCar2);
    }


}
