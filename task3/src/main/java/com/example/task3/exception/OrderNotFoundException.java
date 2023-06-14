package com.example.task3.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Cannot find this order with the id:  " + id);
    }
}