package com.example.payservice.infrastructure.entity;

import com.example.payservice.domain.PaymentMethod;
import com.example.payservice.domain.enums.PaymentMethodType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_method", indexes = {@Index(name = "idx_userId", columnList = "userId")})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class PaymentMethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethodType;

    private String creditCardNumber;

    public static PaymentMethodEntity toEntity(PaymentMethod paymentMethod) {
        return PaymentMethodEntity.builder()
                .id(paymentMethod.getId())
                .userId(paymentMethod.getUserId())
                .paymentMethodType(paymentMethod.getPaymentMethodType())
                .creditCardNumber(paymentMethod.getCreditCardNumber())
                .build();
    }
}
