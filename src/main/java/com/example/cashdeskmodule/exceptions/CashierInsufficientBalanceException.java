package com.example.cashdeskmodule.exceptions;

public class CashierInsufficientBalanceException extends RuntimeException {

    public CashierInsufficientBalanceException() {
    }

    public CashierInsufficientBalanceException(String message) {
        super(message);
    }

    public CashierInsufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CashierInsufficientBalanceException(Throwable cause) {
        super(cause);
    }
}
