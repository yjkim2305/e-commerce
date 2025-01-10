package com.example.payservice.infrastructure.entity;

import com.example.payservice.domain.enums.PaymentMethodType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_method", indexes = {@Index(name = "idx_userId", columnList = "userId")})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaymentMethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethodType;
    private String creditCardNumber;
}
