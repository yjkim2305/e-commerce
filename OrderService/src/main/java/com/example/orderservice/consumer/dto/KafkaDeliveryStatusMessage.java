package com.example.orderservice.consumer.dto;

import com.example.orderservice.domain.enums.DeliveryStatus;
import lombok.Getter;

@Getter
public class KafkaDeliveryStatusMessage {
    private Long orderId;
    private Long deliveryId;
    private DeliveryStatus deliveryStatus;
}
