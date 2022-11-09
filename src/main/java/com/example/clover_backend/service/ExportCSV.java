/*
package com.example.clover_backend.service;

import com.example.clover_backend.dto.DataResponse;
import com.example.clover_backend.repository.KOSPI;
import com.example.clover_backend.repository.KOSPIDataRepository;
import com.example.clover_backend.repository.StockItem;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExportCSV {

    private final KOSPIDataRepository kospiDataRepository;=

    public void writeCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        writeDataToCsv("kospi.csv"); // EC2의 경우 경로 수정
    }

    public void writeDataToCsv(String filePath) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CSVWriter writer = new CSVWriter(new FileWriter(filePath));

        String[] entries = "Date#Open#High#Low#Close#Volume".split("#");
        writer.writeNext(entries);

        List<KOSPI> kospiDataList = kospiDataRepository.findAll();

        for (KOSPI kospi : kospiDataList) {
            writer.writeNext(new String[]{String.valueOf(kospi.getDate()), String.valueOf(kospi.getOpen()),
                    String.valueOf(kospi.getHigh()), String.valueOf(kospi.getLow()),
                    String.valueOf(kospi.getClose()), String.valueOf(kospi.getVolume())});;
        }

        writer.close();
    }
}

 */