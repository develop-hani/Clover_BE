package com.example.clover_backend.controller;

import com.example.clover_backend.dto.PriceData;
import com.example.clover_backend.dto.SignalResponse;
import com.example.clover_backend.service.SignalAndDataService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/signal")
    public SignalResponse getSignal(@RequestParam String stock_code) throws IOException, ParseException {
        return signalAndDataService.getSignal(stock_code);
    }

    @GetMapping("/data")
    public TreeMap<String, PriceData> getData(@RequestParam String stock_code) throws IOException, ParseException {
        return signalAndDataService.getData(stock_code);
    }

}
