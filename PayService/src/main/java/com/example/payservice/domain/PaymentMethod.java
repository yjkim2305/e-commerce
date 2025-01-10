package com.example.payservice.domain;

import com.example.payservice.domain.enums.PaymentMethodType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentMethod {
    private Long id;
    private Long userId;
    private PaymentMethodType paymentMethodType;
    private String creditCardNumber;
    
}
