package com.example.cashdeskmodule.exceptions;

public class CashierInsufficientDenominationsException extends RuntimeException {

    public CashierInsufficientDenominationsException() {
    }

    public CashierInsufficientDenominationsException(String message) {
        super(message);
    }

    public CashierInsufficientDenominationsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CashierInsufficientDenominationsException(Throwable cause) {
        super(cause);
    }
}
