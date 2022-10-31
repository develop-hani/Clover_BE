package com.example.clover_backend.service;

import com.example.clover_backend.dto.StockItemSearchResponse;
import com.example.clover_backend.repository.StockItem;
import com.example.clover_backend.repository.StockItemSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockItemSearchService {
    private final StockItemSearchRepository stockItemRepository;

    public List<StockItemSearchResponse> allStockItems() {
        return stockItemRepository.findAll().stream()
                .map(StockItem::stockItemResponse)
                .collect(Collectors.toList());
    }

    public List<StockItemSearchResponse> searchStockItems(String keyword) throws StockItemSearchNotFoundException {
        try {
            return stockItemRepository.findByKeyword(keyword).stream()
                    .map(StockItem::stockItemResponse)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new StockItemSearchNotFoundException(keyword);
        }

    }
}
