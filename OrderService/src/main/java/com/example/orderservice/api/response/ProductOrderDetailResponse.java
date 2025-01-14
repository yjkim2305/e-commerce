package com.example.orderservice.api.response;

import com.example.orderservice.application.dto.ProductOrderDetailDto;
import com.example.orderservice.domain.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;

@Builder
public record ProductOrderDetailResponse(
        Long id,
        Long userId,
        Long productId,
        Long paymentId,
        Long deliveryId,
        OrderStatus orderStatus,
        String paymentStatus,
        String deliveryStatus
) {
    public static ProductOrderDetailResponse from(ProductOrderDetailDto productOrderDetailDto) {
        return ProductOrderDetailResponse.builder()
                .id(productOrderDetailDto.getId())
                .userId(productOrderDetailDto.getUserId())
                .productId(productOrderDetailDto.getProductId())
                .paymentId(productOrderDetailDto.getPaymentId())
                .deliveryId(productOrderDetailDto.getDeliveryId())
                .orderStatus(productOrderDetailDto.getOrderStatus())
                .paymentStatus(productOrderDetailDto.getPaymentStatus())
                .deliveryStatus(productOrderDetailDto.getDeliveryStatus())
                .build();
    }
}
