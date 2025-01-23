package com.example.orderservice.application.dto;

import com.example.orderservice.domain.enums.PaymentMethodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDto {
    private Long id;
    private Long userId;
    private PaymentMethodType paymentMethodType;
    private String creditCardNumber;
}
