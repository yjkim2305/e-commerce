package com.example.payservice.domain;

import com.example.payservice.domain.enums.PaymentMethodType;
import com.example.payservice.domain.enums.PaymentStatus;
import com.example.payservice.infrastructure.entity.PaymentEntity;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Payment {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long amountKRW;
    private PaymentMethodType paymentMethodType;
    private String paymentData;
    private PaymentStatus paymentStatus;
    private Long referenceCode;

    public static Payment from(PaymentEntity paymentEntity) {
        return Payment.builder()
                .id(paymentEntity.getId())
                .userId(paymentEntity.getUserId())
                .orderId(paymentEntity.getOrderId())
                .amountKRW(paymentEntity.getAmountKRW())
                .paymentMethodType(paymentEntity.getPaymentMethodType())
                .paymentData(paymentEntity.getPaymentData())
                .paymentStatus(paymentEntity.getPaymentStatus())
                .referenceCode(paymentEntity.getReferenceCode())
                .build();
    }

    public static Payment of(Long userId, Long orderId, Long amountKRW, PaymentMethodType paymentMethodType, String paymentData, PaymentStatus paymentStatus, Long referenceCode) {
        return Payment.builder()
                .userId(userId)
                .orderId(orderId)
                .amountKRW(amountKRW)
                .paymentMethodType(paymentMethodType)
                .paymentData(paymentData)
                .paymentStatus(paymentStatus)
                .referenceCode(referenceCode)
                .build();
    }
}
