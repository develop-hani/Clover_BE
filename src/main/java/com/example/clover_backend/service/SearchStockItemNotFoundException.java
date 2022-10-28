package com.example.clover_backend.service;

public class SearchStockItemNotFoundException extends RuntimeException {
    public SearchStockItemNotFoundException(String keyword) {
        super(keyword + "not found");
    }
}
