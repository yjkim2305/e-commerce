package com.example.payservice.consumer.dto;

import com.example.payservice.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class KafkaPaymentResultMessage {
    private Long orderId;
    private Long paymentId;
    private PaymentStatus paymentStatus;

    public static KafkaPaymentResultMessage of(Long orderId, Long paymentId, PaymentStatus paymentStatus) {
        return KafkaPaymentResultMessage.builder()
                .orderId(orderId)
                .paymentId(paymentId)
                .paymentStatus(paymentStatus)
                .build();
    }
}
