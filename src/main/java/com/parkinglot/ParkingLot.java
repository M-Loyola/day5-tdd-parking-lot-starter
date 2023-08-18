package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> cars = new HashMap<>();

    private final int capacity;

    public ParkingLot() {
        this.capacity = 10;
    }
    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if (cars.size() == capacity) return null;
        cars.put(parkingTicket,car);
        return parkingTicket;
    }
    public Car fetch (ParkingTicket parkingTicket) {
        Car fetchedCar = cars.get(parkingTicket);
        cars.remove(parkingTicket);
        return fetchedCar;
    }
}
