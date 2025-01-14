package com.example.orderservice.api.request;

public record OrderProcessRequest(Long orderId, Long paymentMethodId, Long addressId) {
}
