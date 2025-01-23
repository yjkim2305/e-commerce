package com.example.orderservice.infrastructure.entity;

import com.example.orderservice.domain.OrderOutbox;
import com.example.orderservice.domain.enums.OutboxStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "order_outbox")
public class OrderOutboxEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    @Column(columnDefinition = "TEXT")
    private String payload;
    @Enumerated(EnumType.STRING)
    private OutboxStatus status;

    public static OrderOutboxEntity toEntity(OrderOutbox outbox) {
        return OrderOutboxEntity.builder()
                .id(outbox.getId())
                .topic(outbox.getTopic())
                .payload(outbox.getPayload())
                .status(outbox.getStatus())
                .build();
    }


}

