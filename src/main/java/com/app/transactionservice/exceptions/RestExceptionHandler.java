package com.app.transactionservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created By Shameera.A on 3/6/2020
 */

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgsNotValidExceptions(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> sb.append("In field ")
                .append(((FieldError) error).getField()).append(", ").append(error.getDefaultMessage()).append(".  "));
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), sb.toString());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
