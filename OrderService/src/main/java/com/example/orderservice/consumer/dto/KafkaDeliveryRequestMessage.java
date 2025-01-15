package com.example.orderservice.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class KafkaDeliveryRequestMessage {
    private Long orderId;
    private String productName;
    private Long prouductCount;
    private String deliveryAddress;

    public static KafkaDeliveryRequestMessage of(Long orderId, String productName, Long prouductCount, String deliveryAddress) {
        return KafkaDeliveryRequestMessage.builder()
                .orderId(orderId)
                .productName(productName)
                .prouductCount(prouductCount)
                .deliveryAddress(deliveryAddress)
                .build();
    }
}
