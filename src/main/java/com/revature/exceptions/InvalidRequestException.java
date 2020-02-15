package com.revature.exceptions;

public class InvalidRequestException extends MensReaException {

    public InvalidRequestException() {
        super("Request was invalid!");
    }
    public InvalidRequestException(String msg) {super(msg);}

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
