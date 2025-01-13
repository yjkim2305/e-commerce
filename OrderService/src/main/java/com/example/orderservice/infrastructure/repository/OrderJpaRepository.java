package com.example.orderservice.infrastructure.repository;

import com.example.orderservice.infrastructure.entity.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderJpaRepository extends JpaRepository<ProductOrderEntity, Long> {
    List<ProductOrderEntity> findByUserId(Long userId);
}
