package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLot parkingLot = new ParkingLot();

    @Test
    void should_return_ticket_when_park_given_parking_lot_a_car() {
        //Given
        Car car = new Car();

        //When
        ParkingTicket parkingTicket = parkingLot.park(car);

        //Then
        Assertions.assertNotNull(parkingTicket);
    }

    @Test
    void should_return_the_car_when_fetch_given_parking_lot_and_a_ticket() {
        //Given
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        //When
        Car fetchedCar = parkingLot.fetch(parkingTicket);
        //Then
        Assertions.assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_two_tickets_when_fetch_car_twice_given_parking_lot_two_parked_cars_two_parking_tickets() {
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket ticket1 = parkingLot.park(car1);
        ParkingTicket ticket2 = parkingLot.park(car2);

        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);

        //Then
        Assertions.assertEquals(car1, fetchedCar1);
        Assertions.assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_return_nothing_when_fetch_car_given_parking_lot_wrong_ticket() {
        //Given
        ParkingTicket wrongTicket = new ParkingTicket();
        //When
        Car fetchedCar = parkingLot.fetch(wrongTicket);
        //Then
        Assertions.assertNull(fetchedCar);
    }

    @Test
    void should_return_nothing_when_fetch_car_given_used_parking_ticket() {
        //Given
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //When
        Car fetchedCar = parkingLot.fetch(ticket);
        //Then
        Assertions.assertNull(fetchedCar);
    }

    @Test
    void should_return_nothing_when_park_car_given_parking_lot_no_position_and_car() {
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();
        Car car11 = new Car();
        //When
        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);
        parkingLot.park(car4);
        parkingLot.park(car5);
        parkingLot.park(car6);
        parkingLot.park(car7);
        parkingLot.park(car8);
        parkingLot.park(car9);
        parkingLot.park(car10);
        ParkingTicket ticket = parkingLot.park(car11);
        //Then
        Assertions.assertNull(ticket);
    }
}
