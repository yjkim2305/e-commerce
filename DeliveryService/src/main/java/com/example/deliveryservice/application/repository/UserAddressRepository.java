package com.example.deliveryservice.application.repository;

import com.example.deliveryservice.domain.UserAddress;

public interface UserAddressRepository {
    UserAddress save(UserAddress userAddress);
    UserAddress findById(Long id);
    UserAddress findByUserId(Long userId);
}
