package com.example.clover_backend.service;

import com.example.clover_backend.dto.StockItemResponse;
import com.example.clover_backend.repository.StockItem;
import com.example.clover_backend.repository.StockItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockItemService {
    private final StockItemRepository stockItemRepository;

    public List<StockItemResponse> getStockItems() {
        return stockItemRepository.findAll().stream()
                .map(StockItem::stockItemResponse)
                .collect(Collectors.toList());
    }

    public List<StockItemResponse> searchStockItems(String keyword) throws StockItemNotFoundException{
        try {
            return stockItemRepository.findByStockItem(keyword).stream()
                    .map(StockItem::stockItemResponse)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new StockItemNotFoundException(keyword);
        }

    }
}
