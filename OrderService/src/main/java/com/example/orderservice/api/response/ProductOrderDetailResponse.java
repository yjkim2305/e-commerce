package com.example.orderservice.api.response;

import com.example.orderservice.domain.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;

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

}
