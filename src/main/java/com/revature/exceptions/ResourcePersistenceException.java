package com.revature.exceptions;

public class ResourcePersistenceException extends MensReaException{

    public ResourcePersistenceException() {
        super("Could not save data, something went wrong");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }

    public ResourcePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
