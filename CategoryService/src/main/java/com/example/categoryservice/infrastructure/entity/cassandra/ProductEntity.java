package com.example.categoryservice.infrastructure.entity.cassandra;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table("product")
public class ProductEntity {

    @PrimaryKey
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Long price;

    @Column
    private Long stockCount;

    @Column
    private List<String> tags;

    public ProductEntity(Long id, String name, String description, Long price, Long stockCount, List<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockCount = stockCount;
        this.tags = tags;
    }
}
