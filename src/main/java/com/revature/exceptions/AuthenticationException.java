package com.revature.exceptions;

public class AuthenticationException extends MensReaException {

    public AuthenticationException() {
        super("Invalid username or password");
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
