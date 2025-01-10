package com.example.payservice.infrastructure.repository;

import com.example.payservice.application.repository.PaymentMethodRepository;
import com.example.payservice.domain.PaymentMethod;
import com.example.payservice.domain.exception.ErrorCode;
import com.example.payservice.domain.exception.PaymentException;
import com.example.payservice.infrastructure.entity.PaymentMethodEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    private final PaymentMethodJpaRepository paymentMethodJpaRepository;

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        PaymentMethodEntity paymentMethodEntity = paymentMethodJpaRepository.save(PaymentMethodEntity.toEntity(paymentMethod));
        return PaymentMethod.from(paymentMethodEntity);
    }

    @Override
    public PaymentMethod findById(Long id) {
        PaymentMethodEntity paymentMethodEntity = paymentMethodJpaRepository.findById(id).orElseThrow(
                () -> new PaymentException(ErrorCode.PAYMENT_MEHTOD_NOT_EXIST, "결제 수단이 존재하지 않습니다. %s".formatted(id)));
        return PaymentMethod.from(paymentMethodEntity);
    }
}
