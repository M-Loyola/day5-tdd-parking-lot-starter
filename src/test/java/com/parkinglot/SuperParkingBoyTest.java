package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoyTest {
    ParkingLot firstParkingLot = new ParkingLot();
    ParkingLot secondParkingLot = new ParkingLot();
    {
        secondParkingLot.setCapacity(20);
    }
    List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
    SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
    @Test
    void should_park_to_first_parking_lot_when_park_given_a_super_parking_boy_and_two_parking_lots_and_a_car() {
        //Given
        Car car = new Car();
        //When
        ParkingTicket parkingTicket = superParkingBoy.park(car);
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(9, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(20, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_given_a_super_parking_boy_and_two_parking_lots_first_parking_lot_is_full_and_a_car() {
        //Given
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }

        for (Car car : cars) {
            firstParkingLot.park(car);
        }
        //When
        ParkingTicket parkingTicket = superParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(0, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(19, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_given_a_super_parking_boy_and_second_parking_lot_has_larger_position_rate_and_a_car() {
        //Given
        List<Car> cars = new ArrayList<>();
        List<Car> cars2 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            cars.add(new Car());
        }

        for (int i = 0; i < 14; i++) {
            cars2.add(new Car());
        }

        for (Car car : cars) {
            firstParkingLot.park(car);
        }
        for (Car car : cars2) {
            secondParkingLot.park(car);
        }
        //When
        ParkingTicket parkingTicket = superParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(5, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(5, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_first_parking_lot_when_park_given_a_super_parking_boy_and_first_parking_lot_has_larger_position_rate_and_a_car() {
        //Given
        List<Car> cars = new ArrayList<>();
        List<Car> cars2 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            cars.add(new Car());
        }

        for (int i = 0; i < 8; i++) {
            cars2.add(new Car());
        }

        for (Car car : cars) {
            firstParkingLot.park(car);
        }
        for (Car car : cars2) {
            secondParkingLot.park(car);
        }
        //When
        ParkingTicket parkingTicket = superParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(4, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(12, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_return_the_right_car_for_each_ticket_when_fetch_car_given_a_super_parking_boy_and_two_parking_lots_and_two_parking_tickets() {
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket parkingTicket1 = superParkingBoy.park(car1);
        ParkingTicket parkingTicket2 = superParkingBoy.park(car2);
        //When
        Car fetchedCar1 = superParkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = superParkingBoy.fetch(parkingTicket2);
        //Then
        Assertions.assertEquals(car1, fetchedCar1);
        Assertions.assertEquals(car2, fetchedCar2);

    }
}
