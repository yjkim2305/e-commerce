package com.example.deliveryservice.api.request;

public record DeliveryRegisterRequest(
        Long orderId,
        String productName,
        Long productCount,
        String address) {
}
