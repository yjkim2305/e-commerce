package com.example.payservice.application.repository;

import com.example.payservice.domain.PaymentMethod;

public interface PaymentMethodRepository {
    PaymentMethod save(PaymentMethod paymentMethod);
    PaymentMethod findById(Long id);
    PaymentMethod findByUserId(Long userId);
}
