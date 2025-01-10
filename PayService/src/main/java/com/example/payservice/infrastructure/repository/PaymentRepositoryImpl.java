package com.example.payservice.infrastructure.repository;

import com.example.payservice.application.repository.PaymentRepository;
import com.example.payservice.domain.Payment;
import com.example.payservice.domain.exception.ErrorCode;
import com.example.payservice.domain.exception.PaymentException;
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

    @Override
    public Payment findById(Long id) {
        PaymentEntity paymentEntity = paymentJpaRepository.findById(id).orElseThrow(
                () -> new PaymentException(ErrorCode.PAYMENT_NOT_EXIST, "진행되지 않은 결제 건입니다. id: %s".formatted(id))
        );
        return Payment.from(paymentEntity);
    }
}
