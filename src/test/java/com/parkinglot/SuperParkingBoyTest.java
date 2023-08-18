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
}
