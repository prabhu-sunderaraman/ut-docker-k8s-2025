package com.indium;

public class InvalidBookIdException extends RuntimeException {
    public InvalidBookIdException(String message) {
        super(message);
    }
}
