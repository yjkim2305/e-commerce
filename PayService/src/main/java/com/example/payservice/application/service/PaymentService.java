package com.example.payservice.application.service;

import com.example.payservice.application.repository.PaymentMethodRepository;
import com.example.payservice.application.repository.PaymentRepository;
import com.example.payservice.domain.Payment;
import com.example.payservice.domain.PaymentMethod;
import com.example.payservice.domain.enums.PaymentMethodType;
import com.example.payservice.domain.enums.PaymentStatus;
import com.example.payservice.pg.CreditCardPaymentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final CreditCardPaymentAdapter creditCardPaymentAdapter;

    public PaymentMethod registerPaymentMethod(Long userId, PaymentMethodType paymentMethodType, String creditCardNumber) {
        return paymentMethodRepository.save(PaymentMethod.of(userId, paymentMethodType, creditCardNumber));
    }

    @Transactional
    public Payment processPayment(Long userId, Long orderId, Long amountKRW, Long paymentMethodId) {

        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId);

        paymentMethod.validatePaymentMethod();

        //실제 결제 진행
        Long refCode = creditCardPaymentAdapter.processCreditCardPayment(amountKRW, paymentMethod.getCreditCardNumber());

        //결제
        return paymentRepository.save(Payment.of(userId, orderId
                , amountKRW, paymentMethod.getPaymentMethodType()
                , paymentMethod.getCreditCardNumber(), PaymentStatus.COMPLETED, refCode));
    }

    public PaymentMethod getPaymentMehodByUser(Long userId) {
        return paymentMethodRepository.findByUserId(userId);
    }

    public Payment getPayment(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
}
