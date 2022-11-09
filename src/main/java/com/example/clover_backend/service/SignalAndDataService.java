package com.example.clover_backend.service;

import com.example.clover_backend.dto.DataResponse;
import com.example.clover_backend.dto.SignalResponse;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.exec.ExecuteException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignalAndDataService {

    // private final ExportCSV kospiCSV;
    private final WriteInfo writeInfo;
    private final ExecutePython executePython;
    private final ReadSignal readSignal;

    // 1. React에서 받은 종목코드 Python으로 넘기기
    // 2. Python에서 받은 시그널 + _10년치 데이터_ => React로 넘기기(JSON)
    // 3. <2>의 10년치 데이터가 업데이트 되었다면 DB upgrade

    public void getSignal(String itemCode) throws IOException, ParseException {
        // 1-1. python에 10년 치 데이터 넘기기(.csv)
        // kospiCSV.writeCSV();

        // 1-2. python에 종목코드 넘기기(info.json)
        writeInfo.writeStockCode(itemCode);

        // python 코드 실행
        executePython.executePython();

        // react에 시그널 보내기
        // return readSignal.readSignal();
    }

    /*
    public List<DataResponse> getData(String itemCode) {
        // python에서 10년치 데이터 읽기


        // react에 데이터 보내기
        return
    }

     */
}