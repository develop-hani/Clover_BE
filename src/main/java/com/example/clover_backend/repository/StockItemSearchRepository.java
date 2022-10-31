package com.example.clover_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockItemSearchRepository extends JpaRepository<StockItem, String> {

    @Query(value =
            "select * " +
                    "from stockitems " +
                    "where name like %:keyword% or code like %:keyword%", nativeQuery = true)
    List<StockItem> findByKeyword(@Param("keyword") String keyword);

}