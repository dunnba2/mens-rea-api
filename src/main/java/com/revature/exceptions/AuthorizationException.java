package com.revature.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super("Not authorized to perform this action!");
    }
}
