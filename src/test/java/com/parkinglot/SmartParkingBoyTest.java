package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
    ParkingLot firstParkingLot = new ParkingLot();
    ParkingLot secondParkingLot = new ParkingLot();
    List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

    private static List<Car> generateListOfCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void populateParkingLot(List<Car> cars, ParkingLot parkingLot) {
        for (Car car : cars) {
            parkingLot.park(car);
        }
    }

    @Test
    void should_park_to_first_parking_lot_when_park_given_a_smart_parking_boy_and_two_parking_lots_and_a_car() {
        //Given
        Car car = new Car();
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(9, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(10, secondParkingLot.getAvailableCapacity());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_given_a_smart_parking_boy_and_two_parking_lots_first_parking_lot_is_full_and_a_car() {
        //Given
        List<Car> cars = generateListOfCars(10);
        populateParkingLot(cars, firstParkingLot);
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(0, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(9, secondParkingLot.getAvailableCapacity());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_given_a_smart_parking_boy_and_second_parking_lot_has_more_positions_and_a_car() {
        //Given
        List<Car> cars = generateListOfCars(5);
        populateParkingLot(cars, firstParkingLot);
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(5, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(9, secondParkingLot.getAvailableCapacity());
    }

    @Test
    void should_park_to_first_parking_lot_when_park_given_a_smart_parking_boy_and_first_parking_lot_has_more_positions_and_a_car() {
        //Given
        List<Car> cars = generateListOfCars(5);
        populateParkingLot(cars, secondParkingLot);
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(9, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(5, secondParkingLot.getAvailableCapacity());
    }

    @Test
    void should_park_to_first_parking_lot_when_park_given_a_smart_parking_boy_and_both_parking_lots_has_equal_positions_and_a_car() {
        //Given
        List<Car> cars = generateListOfCars(5);
        populateParkingLot(cars, firstParkingLot);
        populateParkingLot(cars, secondParkingLot);
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(4, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(5, secondParkingLot.getAvailableCapacity());
    }

    @Test
    void should_return_the_right_car_for_each_ticket_when_fetch_car_given_a_smart_parking_boy_and_two_parking_lots_and_two_parking_tickets() {
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket parkingTicket1 = smartParkingBoy.park(car1);
        ParkingTicket parkingTicket2 = smartParkingBoy.park(car2);
        //When
        Car fetchedCar1 = smartParkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = smartParkingBoy.fetch(parkingTicket2);
        //Then
        Assertions.assertEquals(car1, fetchedCar1);
        Assertions.assertEquals(car2, fetchedCar2);

    }

    @Test
    void should_return_nothing_with_an_error_message_when_fetch_car_given_a_smart_parking_boy_and_two_parking_lots_and_an_unrecognized_ticket() {
        //Given
        ParkingTicket unrecognizedTicket = new ParkingTicket();
        //When
        //Then
        UnrecognizedTicketException exception = assertThrows(UnrecognizedTicketException.class, () ->
                smartParkingBoy.fetch(unrecognizedTicket));
        Assertions.assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_an_error_message_when_fetch_car_given_a_smart_parking_boy_and_two_parking_lots_and_a_used_ticket() {
        //Given
        Car car = new Car();
        ParkingTicket ticket = smartParkingBoy.park(car);
        smartParkingBoy.fetch(ticket);
        //When
        //Then
        UnrecognizedTicketException exception = assertThrows(UnrecognizedTicketException.class, () ->
                smartParkingBoy.fetch(ticket));
        Assertions.assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_error_message_when_park_car_given_a_smart_parking_boy_and_two_full_parking_lots_and_a_car() {
        //Given
        List<Car> cars = generateListOfCars(10);
        populateParkingLot(cars, firstParkingLot);
        populateParkingLot(cars, secondParkingLot);
        //When
        NoAvailablePositionException exception = assertThrows(NoAvailablePositionException.class, () -> {
            throw new NoAvailablePositionException();
        });
        //Then
        Assertions.assertEquals("No available position.", exception.getMessage());
    }
}
