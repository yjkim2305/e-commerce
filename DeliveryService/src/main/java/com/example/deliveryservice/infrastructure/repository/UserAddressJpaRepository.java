package com.example.deliveryservice.infrastructure.repository;

import com.example.deliveryservice.domain.UserAddress;
import com.example.deliveryservice.infrastructure.entity.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressJpaRepository extends JpaRepository<UserAddressEntity, Long> {
    List<UserAddressEntity> findByUserId(Long userId);
}
