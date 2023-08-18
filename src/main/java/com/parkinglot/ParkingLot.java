package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public static final int DEFAULT_CAPACITY = 10;
    public static final String NO_AVAILABLE_POSITION_ERROR_MESSAGE = "No available position.";
    public static final String UNRECOGNIZED_PARKING_TICKET_ERROR_MESSAGE = "Unrecognized parking ticket.";
    private final Map<ParkingTicket, Car> cars = new HashMap<>();

    private final int capacity;

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }
    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if (isParkingLotFull()) {
            throw new NoAvailablePositionException();
        }
        cars.put(parkingTicket,car);
        return parkingTicket;
    }

    private boolean isParkingLotFull() {
        return cars.size() == capacity;
    }

    public Car fetch (ParkingTicket parkingTicket) {
        if (!cars.containsKey(parkingTicket)) {
            throw new UnrecognizedTicketException();
        }
        return cars.remove(parkingTicket);
    }
}
