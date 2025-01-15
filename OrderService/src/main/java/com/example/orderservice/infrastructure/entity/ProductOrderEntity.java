package com.example.orderservice.infrastructure.entity;

import com.example.orderservice.domain.ProductOrder;
import com.example.orderservice.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Table(name = "product_order")
public class ProductOrderEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId; //단일 상품에 대해서만 주문 가능하다고 가정
    private Long count;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Long paymentId;
    private Long deliveryId;
    private String deliveryAddress;

    public static ProductOrderEntity toEntity(ProductOrder productOrder) {
        return ProductOrderEntity.builder()
                .id(productOrder.getId())
                .userId(productOrder.getUserId())
                .productId(productOrder.getProductId())
                .count(productOrder.getCount())
                .orderStatus(productOrder.getOrderStatus())
                .paymentId(productOrder.getPaymentId())
                .deliveryId(productOrder.getDeliveryId())
                .deliveryAddress(productOrder.getDeliveryAddress())
                .build();
    }
}
