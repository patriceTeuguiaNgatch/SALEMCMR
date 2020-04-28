package org.salem.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class AccountAlreadyExistException extends Exception {

    private static final long serialVersionUID = 1L;

    public AccountAlreadyExistException(String message) {
        super(message);
    }

}