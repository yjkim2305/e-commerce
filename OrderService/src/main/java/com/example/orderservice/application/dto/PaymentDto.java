package com.example.orderservice.application.dto;

import com.example.orderservice.domain.enums.PaymentMethodType;
import com.example.orderservice.domain.enums.PaymentStatus;
import lombok.Getter;

@Getter
public class PaymentDto {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long amountKRW;
    private PaymentMethodType paymentMethodType;
    private String paymentData;
    private PaymentStatus paymentStatus;
    private Long referenceCode;
}
