package com.example.orderservice.domain;

import com.example.orderservice.domain.enums.OrderStatus;
import com.example.orderservice.infrastructure.entity.ProductOrderEntity;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOrder {
    private Long id;
    private Long userId;
    private Long productId;
    private Long count;
    private OrderStatus orderStatus;
    private Long paymentId;
    private Long deliveryId;
    private String deliveryAddress;

    public static ProductOrder from(ProductOrderEntity productOrderEntity) {
        return ProductOrder.builder()
                .id(productOrderEntity.getId())
                .userId(productOrderEntity.getUserId())
                .productId(productOrderEntity.getProductId())
                .count(productOrderEntity.getCount())
                .orderStatus(productOrderEntity.getOrderStatus())
                .paymentId(productOrderEntity.getPaymentId())
                .deliveryId(productOrderEntity.getDeliveryId())
                .deliveryAddress(productOrderEntity.getDeliveryAddress())
                .build();
    }

    public static ProductOrder of(Long userId, Long productId, Long count, OrderStatus orderStatus, Long paymentId, Long deliveryId, String deliveryAddress) {
        return ProductOrder.builder()
                .userId(userId)
                .productId(productId)
                .count(count)
                .orderStatus(orderStatus)
                .paymentId(paymentId)
                .deliveryId(deliveryId)
                .deliveryAddress(deliveryAddress)
                .build();
    }

    public void modifyOrderInfo(Long paymentId, OrderStatus orderStatus) {
        this.paymentId = paymentId;
        this.orderStatus = orderStatus;
    }

    public void modifyOrderStatus(OrderStatus orderStatus, String deliveryAddress) {
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
    }
}
