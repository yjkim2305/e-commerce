package com.example.categoryservice.infrastructure.entity.mysql;

import com.example.categoryservice.domain.SellerProduct;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Table(name = "seller_product")
public class SellerProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sellerId;

    public static SellerProductEntity toEntity(SellerProduct sellerProduct) {
        return SellerProductEntity.builder()
                .id(sellerProduct.getId())
                .sellerId(sellerProduct.getSellerId())
                .build();
    }
}
