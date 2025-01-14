package com.example.orderservice.application.dto;

import com.example.orderservice.domain.enums.PaymentMethodType;

public class PaymentMethodDto {
    private Long id;
    private Long userId;
    private PaymentMethodType paymentMethodType;
    private String creditCardNumber;
}
