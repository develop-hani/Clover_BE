package com.example.clover_backend.repository;

import com.example.clover_backend.dto.StockItemResponse;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="stockitems")
public class StockItem {

    @Id
    @Column(name="code")
    private String code; // 종목코드

    @Column(name="name")
    private String name; // 기업이름

    public StockItemResponse stockItemResponse() {
        return StockItemResponse.builder()
                .code(code)
                .name(name)
                .build();
    }
}