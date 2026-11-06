package com.danzo.rate_demo;

public class CurrentlyNotFoundException extends RuntimeException {
    public CurrentlyNotFoundException(String currency) {
        super("Unknown Currency " + currency);
    }
}
