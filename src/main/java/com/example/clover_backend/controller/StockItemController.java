package com.example.clover_backend.controller;

import com.example.clover_backend.dto.StockItemResponse;
import com.example.clover_backend.repository.StockItem;
import com.example.clover_backend.service.StockItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class StockItemController {

    private final StockItemService stockItemService;

    @GetMapping("/stockItems")
    public List<StockItemResponse> getStockItems() {
        return stockItemService.getStockItems();
    }

    @GetMapping("/search")
    public List<StockItemResponse> searchStockItems(@RequestParam("keyword") String keyword) {
        return stockItemService.searchStockItems(keyword);
    }
}
