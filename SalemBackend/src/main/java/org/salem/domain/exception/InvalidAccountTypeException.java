package org.salem.domain.exception;

public class InvalidAccountTypeException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;

    public InvalidAccountTypeException() {
    }

    public InvalidAccountTypeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}