package com.hangout.core.vendorservice.exceptions;

public class MotherException extends RuntimeException {
    public MotherException(String clientMessage) {
        super(clientMessage);
    }
}
