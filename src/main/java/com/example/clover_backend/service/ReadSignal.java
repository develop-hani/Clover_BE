package com.example.clover_backend.service;

import com.example.clover_backend.dto.SignalResponse;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@RequiredArgsConstructor
public class ReadSignal {
    public SignalResponse readSignal() throws IOException, ParseException {

        JSONParser jsonParser  = new JSONParser();

        // Reader reader = new FileReader("/home/ubuntu/python/signal.json");
        String path = "signal.json";
        FileReader rd = new FileReader(path);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(rd);

        String stockCode = (String) jsonObject.get("stock_code");
        String date = (String) jsonObject.get("date");
        long open = (Long) jsonObject.get("open");
        long high = (Long) jsonObject.get("high");
        long low = (Long) jsonObject.get("low");
        long close = (Long) jsonObject.get("close");
        long signal = (Long) jsonObject.get("signal");
        String reliability = (String) jsonObject.get("신뢰도");

        return SignalResponse.builder()
                .stockCode(stockCode)
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
