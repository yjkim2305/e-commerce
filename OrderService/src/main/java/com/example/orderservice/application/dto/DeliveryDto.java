package com.example.orderservice.application.dto;

import com.example.orderservice.domain.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeliveryDto {
    private Long id;
    private Long orderId;
    private String productName;
    private Long productCount;
    private String address;
    private Long referenceCode;
    private DeliveryStatus status;
}
