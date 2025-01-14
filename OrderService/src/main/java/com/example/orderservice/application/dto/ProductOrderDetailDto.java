package com.example.orderservice.application.dto;

import com.example.orderservice.domain.ProductOrder;
import com.example.orderservice.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductOrderDetailDto {
    private Long id;
    private Long userId;
    private Long productId;
    private Long paymentId;
    private Long deliveryId;
    private OrderStatus orderStatus;
    private String paymentStatus;
    private String deliveryStatus;

    public static ProductOrderDetailDto of(ProductOrder order, PaymentDto paymentDto, DeliveryDto deliveryDto) {
        return ProductOrderDetailDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .productId(order.getProductId())
                .paymentId(order.getPaymentId())
                .deliveryId(order.getDeliveryId())
                .orderStatus(order.getOrderStatus())
                .paymentStatus(paymentDto.getPaymentStatus().toString())
                .deliveryStatus(deliveryDto.getStatus().toString())
                .build();
    }
}
