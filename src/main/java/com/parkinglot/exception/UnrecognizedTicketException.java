package com.parkinglot.exception;

public class UnrecognizedTicketException extends RuntimeException {
    public UnrecognizedTicketException(String message) {
        super(message);
    }

}
