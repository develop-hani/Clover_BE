package com.example.clover_backend.service;

import com.example.clover_backend.dto.PriceData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class ReadData {
    public TreeMap<String, PriceData> readData() throws IOException, ParseException {

        TreeMap<String, PriceData> responseList = new TreeMap<>();
        List<String> dateList = new ArrayList<>();
        JSONParser jsonParser  = new JSONParser();

        String path = "/home/ubuntu/Clover_Project/Python/price.json";
        String str = Files.readString(Path.of(path));
        str = str.replace("\\", "");
        str = str.substring(2, str.length() - 1);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);

        Iterator i = jsonObject.keySet().iterator();

        while (i.hasNext()) {
            String Date = i.next().toString();
            dateList.add(Date);
        }
        for (int a = 0; a < dateList.size(); a++) {
            JSONObject priceObject = (JSONObject) jsonObject.get(dateList.get(a));

            long open = (long) priceObject.get("Open");
            long high = (long) priceObject.get("High");
            long low = (long) priceObject.get("Low");
            long close = (long) priceObject.get("Close");

            PriceData data = PriceData.builder()
                    .open(open)
                    .high(high)
                    .low(low)
                    .close(close)
                    .build();

            responseList.put(dateList.get(a), data);
        }

        return responseList;
    }
}
