package com.example.payservice.api.request;

import com.example.payservice.domain.enums.PaymentMethodType;

public record PaymentMethodRegisterRequest(Long userId, PaymentMethodType paymentMethodType, String paymentMethodName, String paymentMethodDescription, String creditCardNumber) {
}
