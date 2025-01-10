package com.example.payservice;

import com.example.payservice.api.response.PaymentResponse;
import com.example.payservice.domain.exception.PaymentException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentControllerAdvice {
    @ExceptionHandler(PaymentException.class)
    public PaymentResponse handlePaymentException(PaymentException e) {
        return new PaymentResponse(false, e.getErrorCode().getMessage());
    }
}
