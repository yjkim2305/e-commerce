package com.example.deliveryservice.infrastructure.entity;

import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.domain.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "delivery", indexes = {@Index(name = "idx_orderId", columnList = "orderId")})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private String productName;
    private Long productCount;
    private String address;
    private Long referenceCode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public static DeliveryEntity toEntity(Delivery delivery) {
        return DeliveryEntity.builder()
                .id(delivery.getId())
                .orderId(delivery.getOrderId())
                .productName(delivery.getProductName())
                .productCount(delivery.getProductCount())
                .address(delivery.getAddress())
                .referenceCode(delivery.getReferenceCode())
                .status(delivery.getStatus())
                .build();
    }
}
