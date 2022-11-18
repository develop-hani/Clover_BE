package com.example.clover_backend.controller;

import com.example.clover_backend.dto.StockItemSearchResponse;
import com.example.clover_backend.service.StockItemSearchService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/search")
@RequiredArgsConstructor
public class StockItemSearchController {

    private final StockItemSearchService stockItemService;

    @GetMapping("/allItems")
    public List<StockItemSearchResponse> allStockItems() {
        return stockItemService.allStockItems();
    }

    @PostMapping("/eachItem")
    public List<StockItemSearchResponse> searchStockItems(@RequestBody JSONObject item) {
        return stockItemService.searchStockItems(item);
    }
}
