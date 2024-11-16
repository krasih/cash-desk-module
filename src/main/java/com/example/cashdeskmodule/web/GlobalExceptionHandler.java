package com.example.cashdeskmodule.web;

import com.example.cashdeskmodule.exceptions.CashierInsufficientBalanceException;
import com.example.cashdeskmodule.exceptions.CashierInsufficientDenominationsException;
import com.example.cashdeskmodule.exceptions.CashierNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            CashierNotExistsException.class, CashierInsufficientBalanceException.class,
            CashierInsufficientDenominationsException.class
    })
    public ResponseEntity<String> handleCashierNotExistsException(final RuntimeException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> handleCashierNotExistsException(final DateTimeParseException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }
}
