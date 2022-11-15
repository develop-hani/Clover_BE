package com.example.clover_backend.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class WriteInfo {
    public void writeStockCode(JSONObject stock_code) throws IOException{
        FileWriter file = new FileWriter("/home/ubuntu/Clover_Project/Python/info.json");
        //FileWriter file = new FileWriter("info.json");
        file.write(String.valueOf(stock_code));
        file.flush();
        file.close();
    }
}
