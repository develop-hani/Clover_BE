package com.example.clover_backend.controller;

import com.example.clover_backend.dto.PriceData;
import com.example.clover_backend.dto.SignalResponse;
import com.example.clover_backend.service.SignalAndDataService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.TreeMap;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/info")
@RequiredArgsConstructor
public class SignalAndDataController {

    private final SignalAndDataService signalAndDataService;

    @PostMapping("/signal")
    public SignalResponse getSignal(@RequestBody JSONObject stock_code) throws IOException, ParseException {
        return signalAndDataService.getSignal(stock_code);
    }

    @PostMapping("/data")
    public TreeMap<String, PriceData> getData() throws IOException, ParseException {
        return signalAndDataService.getData();
    }

}
