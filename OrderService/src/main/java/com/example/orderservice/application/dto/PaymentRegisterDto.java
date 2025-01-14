package com.example.orderservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PaymentRegisterDto {
   private Long userId;
   private Long orderId;
   private Long amountKRW;
   private Long paymentMethodId;

   public static PaymentRegisterDto of(Long orderId, Long userId, Long amountKRW, Long paymentMethodId) {
      return PaymentRegisterDto.builder()
              .userId(userId)
              .orderId(orderId)
              .amountKRW(amountKRW)
              .paymentMethodId(paymentMethodId)
              .build();
   }
}
