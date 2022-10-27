package com.example.clover_backend.service;

public class StockItemNotFoundException extends RuntimeException {
    public StockItemNotFoundException(String keyword) {
        super(keyword + "not found");
    }
}
