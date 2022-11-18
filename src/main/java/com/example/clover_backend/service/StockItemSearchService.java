package com.example.clover_backend.service;

import com.example.clover_backend.dto.StockItemSearchResponse;
import com.example.clover_backend.repository.StockItem;
import com.example.clover_backend.repository.StockItemSearchRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockItemSearchService {
    private final StockItemSearchRepository stockItemRepository;
    private final ReadList readList;

    public List<StockItemSearchResponse> allStockItems() {
        return stockItemRepository.findAll().stream()
                .map(StockItem::stockItemResponse)
                .collect(Collectors.toList());
    }

    public List<StockItemSearchResponse> searchStockItems(JSONObject item) throws StockItemSearchNotFoundException {
	JSONObject data = new JSONObject(item);
        	String word = data.get("keyword").toString();	
        try {
            return stockItemRepository.findByKeyword(word).stream()
                    .map(StockItem::stockItemResponse)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new StockItemSearchNotFoundException(word);
        }

    }

    // excute at 09:05:00 everyday
    @Scheduled(cron = "0 30 23 * * *")
    public void DBUpdate() throws IOException, ParseException {
        stockItemRepository.deleteAll();
        List<StockItem> stockItems = readList.readList();
        stockItemRepository.saveAll(stockItems);
    }
}