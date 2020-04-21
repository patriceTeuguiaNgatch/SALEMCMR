package org.salem.controller.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.salem.controller.exception.ErrorDetail;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AccountAdviceController {

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<?> handleMethodArgumentNotValid(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        List<ErrorDetail> errorDetails = new ArrayList<>();

        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(
                error -> errorDetails.add(new ErrorDetail(new Date(), error.getField(), (error.getDefaultMessage()))));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException constraintViolationException) {

        List<ErrorDetail> errorDetails = new ArrayList<>();
        constraintViolationException.getConstraintViolations().forEach(constraintViolation -> {
            errorDetails.add(new ErrorDetail(new Date(), constraintViolation.getMessage(),
                    (constraintViolation.getPropertyPath()).toString()));
        });

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleNumberFormatException(NumberFormatException numberFormatException,
            WebRequest request) {

        List<ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails
                .add(new ErrorDetail(new Date(), numberFormatException.getMessage(), request.getDescription(false)));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
            WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), resourceNotFoundException.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidAccountTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleInvalidAccountTypeException(InvalidAccountTypeException invalidAccountTypeException,
            WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), invalidAccountTypeException.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

}