package com.example.deliveryservice.consumer.dto;

import com.example.deliveryservice.domain.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class KafkaDeliveryStatusMessage {
    private Long orderId;
    private Long deliveryId;
    private DeliveryStatus deliveryStatus;

    public static KafkaDeliveryStatusMessage of(Long orderId, Long deliveryId, DeliveryStatus deliveryStatus) {
        return KafkaDeliveryStatusMessage.builder()
                .orderId(orderId)
                .deliveryId(deliveryId)
                .deliveryStatus(deliveryStatus)
                .build();
    }
}
