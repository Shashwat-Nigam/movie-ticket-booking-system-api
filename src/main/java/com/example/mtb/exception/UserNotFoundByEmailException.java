package com.example.mtb.exception;

public class UserNotFoundByEmailException extends RuntimeException {
    public UserNotFoundByEmailException(String message) {
        super(message);
    }
}
