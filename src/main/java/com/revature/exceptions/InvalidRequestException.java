package com.revature.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("Request was invalid!");
    }
    public InvalidRequestException(String msg) {super(msg);}
}
