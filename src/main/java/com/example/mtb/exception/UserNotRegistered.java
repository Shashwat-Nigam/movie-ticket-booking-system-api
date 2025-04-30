package com.example.mtb.exception;

public class UserNotRegistered extends  RuntimeException {
    public UserNotRegistered(String message) {
        super(message);
    }
}
