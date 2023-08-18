package com.parkinglot;

import com.parkinglot.exception.UnrecognizedTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public static final int DEFAULT_CAPACITY = 10;
    private final Map<ParkingTicket, Car> cars = new HashMap<>();

    private final int capacity;

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }
    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if (isParkingLotFull()) {
            throw new UnrecognizedTicketException("No available position.");
        }
        cars.put(parkingTicket,car);
        return parkingTicket;
    }

    private boolean isParkingLotFull() {
        return cars.size() == capacity;
    }

    public Car fetch (ParkingTicket parkingTicket) {
        if (!cars.containsKey(parkingTicket)) {
            throw new UnrecognizedTicketException("Unrecognized parking ticket.");
        }
        return cars.remove(parkingTicket);
    }
}
