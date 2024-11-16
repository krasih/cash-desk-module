package com.example.cashdeskmodule.exceptions;

public class CashierNotExistsException extends RuntimeException {

    public CashierNotExistsException() {
    }

    public CashierNotExistsException(String message) {
        super(message);
    }

    public CashierNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CashierNotExistsException(Throwable cause) {
        super(cause);
    }
}
