package com.example.orderservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductDecreaseStockCountDto {
    private Long stockCount;

    public static ProductDecreaseStockCountDto from(Long stockCount) {
        return ProductDecreaseStockCountDto.builder()
                .stockCount(stockCount)
                .build();
    }
}
