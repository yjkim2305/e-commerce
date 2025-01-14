package com.example.orderservice.application.dto;

import com.example.orderservice.domain.enums.PaymentMethodType;
import lombok.Getter;

@Getter
public class PaymentMethodDto {
    private Long id;
    private Long userId;
    private PaymentMethodType paymentMethodType;
    private String creditCardNumber;
}
