package com.revature.exceptions;

public class MensReaException extends RuntimeException {

    public MensReaException() {
    }

    public MensReaException(String message) {
        super(message);
    }

    public MensReaException(String message, Throwable cause) {
        super(message, cause);
    }
}
