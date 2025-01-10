package com.example.payservice.infrastructure.repository;

import com.example.payservice.infrastructure.entity.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentMethodJpaRepository extends JpaRepository<PaymentMethodEntity, Long> {
    List<PaymentMethodEntity> findByUserId(Long userId);
}
