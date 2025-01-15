package com.example.payservice.consumer.dto;

import lombok.Getter;

@Getter
public class KafkaPaymentProcessMessage {
    private Long userId;
    private Long orderId;
    private Long amountKRW;
    private Long paymentMethodId;
}
