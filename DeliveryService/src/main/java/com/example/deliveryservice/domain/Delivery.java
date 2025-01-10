package com.example.deliveryservice.domain;

import com.example.deliveryservice.infrastructure.entity.DeliveryEntity;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Delivery {

    private Long id;
    private Long orderId;
    private String productName;
    private String address;
    private Long referenceCode;

    public static Delivery from(DeliveryEntity deliveryEntity) {
        return Delivery.builder()
                .id(deliveryEntity.getId())
                .orderId(deliveryEntity.getOrderId())
                .productName(deliveryEntity.getProductName())
                .address(deliveryEntity.getAddress())
                .referenceCode(deliveryEntity.getReferenceCode())
                .build();
    }
}
