package com.example.deliveryservice.infrastructure.entity;

import com.example.deliveryservice.domain.Delivery;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "delivery")
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

    public static DeliveryEntity toEntity(Delivery delivery) {
        return DeliveryEntity.builder()
                .id(delivery.getId())
                .orderId(delivery.getOrderId())
                .productName(delivery.getProductName())
                .address(delivery.getAddress())
                .referenceCode(delivery.getReferenceCode())
                .build();
    }
}
