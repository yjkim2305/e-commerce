package com.example.orderservice.api.request;

public record OrderCreateRequest(Long userId, Long productId, Long count) {
}
