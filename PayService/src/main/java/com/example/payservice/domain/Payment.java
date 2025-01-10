package com.example.payservice.domain;

import com.example.payservice.domain.enums.PaymentMethodType;
import com.example.payservice.domain.enums.PaymentStatus;
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
}
