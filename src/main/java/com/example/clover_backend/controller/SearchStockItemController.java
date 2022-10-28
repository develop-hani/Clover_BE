package com.example.clover_backend.controller;

import com.example.clover_backend.dto.SearchStockItemResponse;
import com.example.clover_backend.service.SearchStockItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class SearchStockItemController {

    private final SearchStockItemService stockItemService;

    @GetMapping("/stockItems")
    public List<SearchStockItemResponse> getStockItems() {
        return stockItemService.getStockItems();
    }

    @GetMapping("/search")
    public List<SearchStockItemResponse> searchStockItems(@RequestParam("keyword") String keyword) {
        return stockItemService.searchStockItems(keyword);
    }
}
