package com.example.payservice.pg;

public interface CreditCardPaymentAdapter {
    Long processCreditCardPayment(Long amountKRW, String creditCardNumber);
}
