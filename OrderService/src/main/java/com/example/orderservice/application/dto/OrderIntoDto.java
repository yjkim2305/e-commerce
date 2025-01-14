package com.example.orderservice.application.dto;

import jakarta.persistence.criteria.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class OrderIntoDto {
    private Long orderId;
    private PaymentMethodDto paymentMethod;
    private UserAddressDto userAddress;

    public static OrderIntoDto of(Long orderId, PaymentMethodDto paymentMethod, UserAddressDto userAddress) {
        return OrderIntoDto.builder()
                .orderId(orderId)
                .paymentMethod(paymentMethod)
                .userAddress(userAddress)
                .build();
    }
}
