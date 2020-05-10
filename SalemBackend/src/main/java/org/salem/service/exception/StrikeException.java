package org.salem.service.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class StrikeException extends Exception {
    private static final long serialVersionUID = 1L;

    public StrikeException(String message) {
        super(message);
    }
}