package com.example.orderservice.domain;

import com.example.orderservice.domain.enums.OutboxStatus;
import com.example.orderservice.infrastructure.entity.OrderOutboxEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderOutbox {
    private Long id;
    private String topic;
    private String payload;
    private OutboxStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static OrderOutbox from(OrderOutboxEntity entity) {
        return OrderOutbox.builder()
                .id(entity.getId())
                .topic(entity.getTopic())
                .payload(entity.getPayload())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static OrderOutbox of(String topic, String payload, OutboxStatus status) {
        return OrderOutbox.builder()
                .topic(topic)
                .payload(payload)
                .status(status)
                .build();
    }
}
