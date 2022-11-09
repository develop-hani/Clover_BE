package com.example.clover_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignalResponse {
    private String stockCode;
    private String date;
    private long open;
    private long high;
    private long low;
    private long close;
    private long signal;
    private String reliability;
}
