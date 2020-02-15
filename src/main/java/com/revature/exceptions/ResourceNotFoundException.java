package com.revature.exceptions;

public class ResourceNotFoundException extends MensReaException {

    public ResourceNotFoundException() {
        super("Could not find your request");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
