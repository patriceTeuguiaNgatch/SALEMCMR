package org.salem.controller.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.salem.controller.dto.ResponseDto;
import org.salem.controller.exception.ErrorDetail;
import org.salem.domain.exception.AccountAlreadyExistException;
import org.salem.domain.exception.InvalidAccountTypeException;
import org.salem.domain.exception.InvalidDonTypeException;
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

                methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error -> errorDetails
                                .add(new ErrorDetail(new Date(), error.getField(), (error.getDefaultMessage()))));
                ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetails);

                return ResponseEntity.accepted().body(responseDto);
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
                ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetails);

                return ResponseEntity.accepted().body(responseDto);
        }

        @ExceptionHandler(NumberFormatException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ResponseEntity<?> handleNumberFormatException(NumberFormatException numberFormatException,
                        WebRequest request) {

                List<ErrorDetail> errorDetails = new ArrayList<>();
                errorDetails.add(new ErrorDetail(new Date(), numberFormatException.getMessage(),
                                request.getDescription(false)));
                ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetails);

                return ResponseEntity.accepted().body(responseDto);
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ResponseBody
        public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                        WebRequest request) {
                ErrorDetail errorDetail = new ErrorDetail(new Date(), resourceNotFoundException.getMessage(),
                                request.getDescription(false));
                ResponseDto responseDto = new ResponseDto(HttpStatus.NOT_FOUND.toString(), null, errorDetail);

                return ResponseEntity.accepted().body(responseDto);
        }

        @ExceptionHandler(InvalidAccountTypeException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ResponseEntity<?> handleInvalidAccountTypeException(
                        InvalidAccountTypeException invalidAccountTypeException, WebRequest request) {
                ErrorDetail errorDetail = new ErrorDetail(new Date(), invalidAccountTypeException.getMessage(),
                                request.getDescription(false));
                ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

                return ResponseEntity.accepted().body(responseDto);
        }

        @ExceptionHandler(InvalidDonTypeException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ResponseEntity<?> handleInvalidDonTypeException(InvalidDonTypeException invalidDonTypeException,
                        WebRequest request) {
                ErrorDetail errorDetail = new ErrorDetail(new Date(), invalidDonTypeException.getMessage(),
                                request.getDescription(false));
                ResponseDto responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), null, errorDetail);

                return ResponseEntity.accepted().body(responseDto);
        }

        @ExceptionHandler(AccountAlreadyExistException.class)
        @ResponseStatus(HttpStatus.FOUND)
        @ResponseBody
        public ResponseEntity<?> handleAccountAlreadyExistException(
                        AccountAlreadyExistException accountAlreadyExistException, WebRequest request) {
                ErrorDetail errorDetail = new ErrorDetail(new Date(), accountAlreadyExistException.getMessage(),
                                request.getDescription(false));
                ResponseDto responseDto = new ResponseDto(HttpStatus.FOUND.toString(), null, errorDetail);

                return ResponseEntity.accepted().body(responseDto);
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ResponseBody
        public ResponseEntity<?> handleException(Exception exception, WebRequest request) {
                ErrorDetail errorDetail = new ErrorDetail(new Date(), exception.getMessage(),
                                request.getDescription(false));
                ResponseDto responseDto = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.toString(), null,
                                errorDetail);

                return ResponseEntity.accepted().body(responseDto);
        }

}