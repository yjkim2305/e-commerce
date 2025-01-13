package com.example.categoryservice.domain;

import com.example.categoryservice.infrastructure.entity.mysql.SellerProductEntity;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SellerProduct {
    private Long id;
    private Long sellerId;

    public static SellerProduct from(SellerProductEntity sellerProductEntity) {
        return SellerProduct.builder()
                .id(sellerProductEntity.getId())
                .sellerId(sellerProductEntity.getSellerId())
                .build();
    }
}
