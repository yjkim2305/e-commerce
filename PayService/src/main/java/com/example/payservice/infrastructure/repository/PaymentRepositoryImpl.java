package com.example.payservice.infrastructure.repository;

import com.example.payservice.application.repository.PaymentRepository;
import com.example.payservice.domain.Payment;
import com.example.payservice.infrastructure.entity.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment save(Payment payment) {
        PaymentEntity paymentEntity = paymentJpaRepository.save(PaymentEntity.toEntity(payment));
        return Payment.from(paymentEntity);
    }
}
