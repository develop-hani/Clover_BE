package com.example.clover_backend.repository;

import com.example.clover_backend.dto.StockItemSearchResponse;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="stockitems")
public class StockItem {

    @Id
    @Column(name="code")
    private String code; // 종목코드

    @Column(name="name")
    private String name; // 기업이름

    public StockItemSearchResponse stockItemResponse() {
        return StockItemSearchResponse.builder()
                .code(code)
                .name(name)
                .build();
    }
}