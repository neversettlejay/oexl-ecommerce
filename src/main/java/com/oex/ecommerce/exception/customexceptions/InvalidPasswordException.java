package com.oex.ecommerce.exception.customexceptions;


public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}