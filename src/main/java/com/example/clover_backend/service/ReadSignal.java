package com.example.clover_backend.service;

import com.example.clover_backend.dto.SignalResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ReadSignal {
    public SignalResponse readSignal() throws IOException, ParseException {

        JSONParser jsonParser  = new JSONParser();

        String path = "/home/ubuntu/Clover_Project/Python/signal.json";
	String str = Files.readString(Path.of(path));
	str = str.substring(1, str.length());

        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);

	System.out.println(jsonObject);

        String stockCode = (String) jsonObject.get("stock_code");
        String date = (String) jsonObject.get("date");
        long open = (Long) jsonObject.get("open");
        long high = (Long) jsonObject.get("high");
        long low = (Long) jsonObject.get("low");
        long close = (Long) jsonObject.get("close");
        long signal = 3;
        Object getSignal = jsonObject.get("signal");
        if(getSignal instanceof Long){
            signal = (Long) getSignal;
        } else if(getSignal instanceof String){
            signal = -1;
        }
        String reliability = (String) jsonObject.get("신뢰도");

        return SignalResponse.builder()
                .stock_code(stockCode)
                .date(date)
                .open(open)
                .high(high)
                .low(low)
                .close(close)
                .signal(signal)
                .reliability(reliability)
                .build();
    }
}
