package com.example.clover_backend.service;

public class StockItemSearchNotFoundException extends RuntimeException {
    public StockItemSearchNotFoundException(String keyword) {
        super(keyword + "not found");
    }
}
