package com.example.clover_backend.service;

import com.example.clover_backend.dto.DataResponse;
import com.example.clover_backend.dto.PriceData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class ReadData {
    public List<HashMap<String, PriceData>> readData() throws IOException, ParseException {

        List<String> dateList = new ArrayList<>();
        List<PriceData> priceList = new ArrayList<>();
        List<HashMap<String, PriceData>> responseList = new ArrayList<>();

        JSONParser jsonParser  = new JSONParser();

        String path = "/home/ubuntu/Clover_Project/Python/Price.json";
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

            long Open = (long) priceObject.get("Open");
            long High = (long) priceObject.get("High");
            long Low = (long) priceObject.get("Low");
            long Close = (long) priceObject.get("Close");

            priceList.add(PriceData.builder()
                    .Open(Open)
                    .High(High)
                    .Low(Low)
                    .Close(Close)
                    .build());
        }
        for (int c = 0; c < priceList.size(); c++) {
            HashMap<String, PriceData> tmp = new HashMap<>();
            tmp.put(dateList.get(c), priceList.get(c));

            responseList.add(tmp);        }

        return responseList;
    }
}
