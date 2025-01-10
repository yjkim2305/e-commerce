package com.example.payservice.infrastructure.entity;

import com.example.payservice.domain.Payment;
import com.example.payservice.domain.enums.PaymentMethodType;
import com.example.payservice.domain.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment", indexes = {@Index(name = "idx_userId", columnList = "userId")})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class PaymentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(unique = true)
    private Long orderId;

    private Long amountKRW;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethodType;

    private String paymentData;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(unique = true)
    private Long referenceCode;

    public static PaymentEntity toEntity(Payment payment) {
        return PaymentEntity.builder()
                .id(payment.getId())
                .userId(payment.getUserId())
                .orderId(payment.getOrderId())
                .amountKRW(payment.getAmountKRW())
                .paymentMethodType(payment.getPaymentMethodType())
                .paymentData(payment.getPaymentData())
                .paymentStatus(payment.getPaymentStatus())
                .referenceCode(payment.getReferenceCode())
                .build();
    }
}
