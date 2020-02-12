package com.revature.exceptions;

public class ResourcePersistenceException extends RuntimeException{

    public ResourcePersistenceException() {
        super("Could not save data, something went wrong");
    }
}
