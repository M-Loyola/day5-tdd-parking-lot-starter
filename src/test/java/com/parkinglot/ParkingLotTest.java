package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {
    ParkingLot parkingLot = new ParkingLot();

    private static List<Car> generateListOfCars() {
        return IntStream.range(0, 10)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void populateParkingLot(List<Car> cars, ParkingLot parkingLot) {
        cars.forEach(parkingLot::park);
    }

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
    void should_return_nothing_with_error_message_when_fetch_car_given_parking_lot_wrong_ticket() {
        //Given
        ParkingTicket wrongTicket = new ParkingTicket();
        //When
        //Then
        UnrecognizedTicketException exception = assertThrows(UnrecognizedTicketException.class, () ->
                parkingLot.fetch(wrongTicket));
        Assertions.assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_error_message_when_fetch_car_given_used_parking_ticket() {
        //Given
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //When
        //Then
        UnrecognizedTicketException exception = assertThrows(UnrecognizedTicketException.class, () ->
                parkingLot.fetch(ticket));
        Assertions.assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_error_message_when_park_car_given_parking_lot_no_position_and_car() {
        //Given
        List<Car> cars = generateListOfCars();
        populateParkingLot(cars, parkingLot);
        //When
        NoAvailablePositionException exception = assertThrows(NoAvailablePositionException.class, () -> {
            throw new NoAvailablePositionException();
        });
        //Then
        Assertions.assertEquals("No available position.", exception.getMessage());
    }
}
