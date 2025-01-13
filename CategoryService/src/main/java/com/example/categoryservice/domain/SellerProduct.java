package com.example.categoryservice.domain;

import com.example.categoryservice.infrastructure.entity.mysql.SellerProductEntity;
import jnr.ffi.annotations.LongLong;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SellerProduct {
    private Long id;
    private Long sellerId;

    public static SellerProduct from(Long sellerId) {
        return SellerProduct.builder()
                .sellerId(sellerId)
                .build();
    }

    public static SellerProduct from(SellerProductEntity sellerProductEntity) {
        return SellerProduct.builder()
                .id(sellerProductEntity.getId())
                .sellerId(sellerProductEntity.getSellerId())
                .build();
    }

    public static List<SellerProduct> fromByEntityList(List<SellerProductEntity> sellerProductEntityList) {
        return sellerProductEntityList.stream()
                .map(SellerProduct::from)
                .toList();
    }
}
