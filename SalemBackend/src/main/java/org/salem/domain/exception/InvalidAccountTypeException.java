package org.salem.domain.exception;

public class InvalidAccountTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidAccountTypeException() {
    }

    public InvalidAccountTypeException(String message) {
        super(message);
    }
}