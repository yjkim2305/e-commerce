package com.example.deliveryservice.api.request;

public record UserAddressRegisterRequest(Long userId, String address, String alias) {
}
