package com.example.deliveryservice.consumer.dto;

import lombok.Getter;

@Getter
public class KafkaDeliveryProcessMessage {
    private Long orderId;
    private String productName;
    private Long productCount;
    private String address;
}
