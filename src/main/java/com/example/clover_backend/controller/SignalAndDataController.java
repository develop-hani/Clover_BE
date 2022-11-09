package com.example.clover_backend.controller;

import com.example.clover_backend.dto.DataResponse;
import com.example.clover_backend.dto.SignalResponse;
import com.example.clover_backend.service.SignalAndDataService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.exec.ExecuteException;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/info")
@RequiredArgsConstructor
public class SignalAndDataController {

    private final SignalAndDataService signalAndDataService;

    @GetMapping("/signal")
    public void getSignal(@RequestParam String itemCode) throws IOException, ParseException {
        // return signalAndDataService.getSignal(itemCode);
    }

    /*
    @GetMapping("/data")
    public List<DataResponse> getData(@RequestParam String itemCode) {

        return signalAndDataService.getData(itemCode);
    }

     */

}
