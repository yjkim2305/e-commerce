package com.example.orderservice.domain;

import com.example.orderservice.domain.enums.OrderStatus;
import com.example.orderservice.infrastructure.entity.ProductOrderEntity;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOrder {
    private Long id;
    private Long userId;
    private Long productId;
    private Long count;
    private OrderStatus orderStatus;
    private Long paymentId;
    private Long deliveryId;

    public static ProductOrder from(ProductOrderEntity productOrderEntity) {
        return ProductOrder.builder()
                .id(productOrderEntity.getId())
                .userId(productOrderEntity.getUserId())
                .productId(productOrderEntity.getProductId())
                .count(productOrderEntity.getCount())
                .orderStatus(productOrderEntity.getOrderStatus())
                .paymentId(productOrderEntity.getPaymentId())
                .deliveryId(productOrderEntity.getDeliveryId())
                .build();
    }

    public static ProductOrder of(Long userId, Long productId, Long count, OrderStatus orderStatus, Long paymentId, Long deliveryId) {
        return ProductOrder.builder()
                .userId(userId)
                .productId(productId)
                .count(count)
                .orderStatus(orderStatus)
                .paymentId(paymentId)
                .deliveryId(deliveryId)
                .build();
    }
}
