package com.example.orderservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeliveryRegisterDto {
    private Long orderId;
    private String productName;
    private Long productCount;
    private String address;

    public static DeliveryRegisterDto of(Long orderId, String productName, Long productCount, String address) {
        return DeliveryRegisterDto.builder()
                .orderId(orderId)
                .productName(productName)
                .productCount(productCount)
                .address(address)
                .build();
    }
}
