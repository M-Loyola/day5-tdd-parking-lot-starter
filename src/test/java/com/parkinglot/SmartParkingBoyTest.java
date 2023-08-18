package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    ParkingLot firstParkingLot = new ParkingLot();
    ParkingLot secondParkingLot = new ParkingLot();
    List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
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
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }

        for (Car car : cars) {
            firstParkingLot.park(car);
        }
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //Then
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(0, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(9, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_given_a_smart_parking_boy_and_second_parking_lot_has_more_positions_and_a_car(){
        //Given
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            cars.add(new Car());
        }

        for (Car car : cars) {
            firstParkingLot.park(car);
        }
        //When
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        Assertions.assertNotNull(parkingTicket);
        Assertions.assertEquals(5, firstParkingLot.getAvailableCapacity());
        Assertions.assertEquals(9, secondParkingLot.getAvailableCapacity());
        //Then
    }
}
