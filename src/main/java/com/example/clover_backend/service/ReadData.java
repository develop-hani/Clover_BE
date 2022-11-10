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
import java.util.Iterator;
import java.util.List;

@Service
public class ReadData {
    public List<DataResponse> readData() throws IOException, ParseException {

        List<String> dateList = new ArrayList<>();
        List<PriceData> priceList = new ArrayList<>();
        List<DataResponse> responseList = new ArrayList<>();

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

            long open = (long) priceObject.get("Open");
            long high = (long) priceObject.get("High");
            long low = (long) priceObject.get("Low");
            long close = (long) priceObject.get("Close");

            priceList.add(PriceData.builder()
                    .open(open)
                    .high(high)
                    .low(low)
                    .close(close)
                    .build());
        }
        for (int c = 0; c < priceList.size(); c++) {
            DataResponse tmpdata = DataResponse.builder()
                            .date(dateList.get(c))
                            .priceData(priceList.get(c))
                            .build();
            responseList.add(tmpdata);
        }

        return responseList;
    }
}
