package com.example.deliveryservice.domain;

import com.example.deliveryservice.domain.enums.DeliveryStatus;
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
    private Long productCount;
    private String address;
    private Long referenceCode;
    private DeliveryStatus status;

    public static Delivery from(DeliveryEntity deliveryEntity) {
        return Delivery.builder()
                .id(deliveryEntity.getId())
                .orderId(deliveryEntity.getOrderId())
                .productName(deliveryEntity.getProductName())
                .address(deliveryEntity.getAddress())
                .referenceCode(deliveryEntity.getReferenceCode())
                .build();
    }

    public static Delivery of(Long orderId, String productName, Long productCount, String address, Long referenceCode, DeliveryStatus status) {
        return Delivery.builder()
                .orderId(orderId)
                .productName(productName)
                .productCount(productCount)
                .address(address)
                .referenceCode(referenceCode)
                .status(status)
                .build();
    }
}
