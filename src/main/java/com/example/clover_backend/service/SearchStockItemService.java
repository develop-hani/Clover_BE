package com.example.clover_backend.service;

import com.example.clover_backend.dto.SearchStockItemResponse;
import com.example.clover_backend.repository.StockItem;
import com.example.clover_backend.repository.SearchStockItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchStockItemService {
    private final SearchStockItemRepository stockItemRepository;

    public List<SearchStockItemResponse> getStockItems() {
        return stockItemRepository.findAll().stream()
                .map(StockItem::stockItemResponse)
                .collect(Collectors.toList());
    }

    public List<SearchStockItemResponse> searchStockItems(String keyword) throws SearchStockItemNotFoundException {
        try {
            return stockItemRepository.findByStockItem(keyword).stream()
                    .map(StockItem::stockItemResponse)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new SearchStockItemNotFoundException(keyword);
        }

    }
}
