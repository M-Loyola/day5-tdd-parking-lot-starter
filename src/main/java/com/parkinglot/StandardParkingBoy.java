package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

import java.util.List;

public class StandardParkingBoy {
    private final List<ParkingLot> parkingLots;
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasAvailableCapacity())
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);
    }
}
