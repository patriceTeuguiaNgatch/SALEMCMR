package org.salem.domain.exception;

public class InvalidDonTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidDonTypeException() {
    }

    public InvalidDonTypeException(String message) {
        super(message);
    }
}