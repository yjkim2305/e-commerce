package com.example.payservice.infrastructure.entity;

import com.example.payservice.domain.enums.PaymentMethodType;
import com.example.payservice.domain.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaymentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long orderId;
    private Long amountKRW;
    private PaymentMethodType paymentMethodType;
    private String paymentData;
    private PaymentStatus paymentStatus;
    private Long referenceCode;
}
