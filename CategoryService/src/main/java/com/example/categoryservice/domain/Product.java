package com.example.categoryservice.domain;

import com.example.categoryservice.infrastructure.entity.cassandra.ProductEntity;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Product {
    private Long id;
    private Long sellerId;
    private String name;
    private String description;
    private Long price;
    private Long stockCount;
    private List<String> tags;

    public static Product from(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .sellerId(productEntity.getSellerId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .stockCount(productEntity.getStockCount())
                .tags(productEntity.getTags())
                .build();
    }

    public static Product of(Long id, Long sellerId, String name, String description, Long price, Long stockCount, List<String> tags) {
        return Product.builder()
                .id(id)
                .sellerId(sellerId)
                .name(name)
                .description(description)
                .price(price)
                .stockCount(stockCount)
                .tags(tags)
                .build();
    }

    public void decreaseStockCount(Long stockCount) {
        this.stockCount -= stockCount;
    }
}
