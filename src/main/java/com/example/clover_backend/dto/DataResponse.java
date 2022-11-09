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
public class DataResponse {
    private Date date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
}
