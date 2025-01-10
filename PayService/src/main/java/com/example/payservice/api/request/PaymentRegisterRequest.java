package com.example.payservice.api.request;

public record PaymentRegisterRequest(Long userId, Long orderId, Long amountKRW, Long paymentMethodId) {
}
