package com.example.clover_backend.service;

import com.example.clover_backend.repository.StockItem;
import com.example.clover_backend.repository.StockItemSearchRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadList {
    private final StockItemSearchRepository stockItemRepository;

    public void readList() throws IOException, ParseException {
        List<String> idx = new ArrayList<>();
        List<StockItem> updateStockItems = new ArrayList<>();
        StockItem data = new StockItem();

        JSONParser jsonParser = new JSONParser();
        String path = "/home/ubuntu/Clover_Project/Python/listing.json";
        String str = Files.readString(Path.of(path));
        str = str.replace("\\", "");
        str = str.substring(2, str.length() - 1);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);

        // System.out.println(jsonObject);

        Iterator i = jsonObject.keySet().iterator();
        while (i.hasNext()) {
            String index = i.next().toString();
            idx.add(index);
        }
        for (int a = 0; a < idx.size(); a++) {
            JSONObject priceObject = (JSONObject) jsonObject.get(idx.get(a));
            String code = (String) priceObject.get("Code");
            String name = (String) priceObject.get("Name");

            data.setCode(code);
            data.setName(name);

            stockItemRepository.save(data);
        }
    }
}
