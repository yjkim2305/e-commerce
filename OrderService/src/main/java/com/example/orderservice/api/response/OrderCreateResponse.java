package com.example.orderservice.api.response;

public record OrderCreateResponse(Long userId, Long productId, Long count) {
}
