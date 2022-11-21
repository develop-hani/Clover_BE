package com.example.clover_backend.service;

import com.example.clover_backend.dto.PriceData;
import com.example.clover_backend.dto.SignalResponse;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.TreeMap;
@Service
@RequiredArgsConstructor
public class SignalAndDataService {

    // private final ExportCSV kospiCSV;
    private final WriteInfo writeInfo;
    private final ExecutePython executePython;
    private final ReadSignal readSignal;
    private final ReadData readData;

    // 1. React에서 받은 종목코드 Python으로 넘기기
    // 2. Python에서 받은 시그널 + _10년치 데이터_ => React로 넘기기(JSON)
    // 3. <2>의 10년치 데이터가 업데이트 되었다면 DB upgrade

    public SignalResponse getSignal() throws IOException, ParseException {
        // 1-1. python에 10년 치 데이터 넘기기(.csv)
        // kospiCSV.writeCSV();

        // 1-2. python에 종목코드 넘기기(info.json)
        // System.out.println(stock_code);
        // writeInfo.writeStockCode(stock_code);

        // python 코드 실행
        // executePython.executePython();
        // executePython.executePython();

        // react에 시그널 보내기
        return readSignal.readSignal();
    }

    public TreeMap<String, PriceData> getData() throws IOException, ParseException {
        return readData.readData();
    }
}