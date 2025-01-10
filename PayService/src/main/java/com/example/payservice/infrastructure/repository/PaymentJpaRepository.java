package com.example.payservice.infrastructure.repository;

import com.example.payservice.domain.Payment;
import com.example.payservice.infrastructure.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
}
