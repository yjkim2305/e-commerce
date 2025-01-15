package com.example.orderservice.consumer.dto;

import lombok.Getter;

@Getter
public class KafkaPaymentResultMessage {
    private Long userId;
    private Long orderId;
    private Long amountKRW;
    private Long paymentMethodId;

}
