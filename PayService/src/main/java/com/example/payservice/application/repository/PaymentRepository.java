package com.example.payservice.application.repository;

import com.example.payservice.domain.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);
    Payment findById(Long id);
}
