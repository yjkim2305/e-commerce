package com.example.payservice.domain;

import com.example.payservice.domain.enums.PaymentMethodType;
import com.example.payservice.domain.exception.ErrorCode;
import com.example.payservice.domain.exception.PaymentException;
import com.example.payservice.infrastructure.entity.PaymentMethodEntity;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentMethod {
    private Long id;
    private Long userId;
    private PaymentMethodType paymentMethodType;
    private String creditCardNumber;

    public static PaymentMethod from(PaymentMethodEntity paymentMethodEntity) {
        return PaymentMethod.builder()
                .id(paymentMethodEntity.getId())
                .userId(paymentMethodEntity.getUserId())
                .paymentMethodType(paymentMethodEntity.getPaymentMethodType())
                .creditCardNumber(paymentMethodEntity.getCreditCardNumber())
                .build();
    }

    public static PaymentMethod of(Long userId, PaymentMethodType paymentMethodType, String creditCardNumber) {
        return PaymentMethod.builder()
                .userId(userId)
                .paymentMethodType(paymentMethodType)
                .creditCardNumber(creditCardNumber)
                .build();
    }

    public void validatePaymentMethod() {
        if (!isOfType(PaymentMethodType.CREDIT_CARD)) {
            throw new PaymentException(ErrorCode.USUPORT_PAYMENT_METHOD, "지원하지 않는 결제 수단입니다.");
        }
    }

    public boolean isOfType(PaymentMethodType type) {
        return this.paymentMethodType == type;
    }
}
