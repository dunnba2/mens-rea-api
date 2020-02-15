package com.revature.exceptions;

public class AuthorizationException extends MensReaException {

    public AuthorizationException() {
        super("Not authorized to perform this action!");
    }

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
