package com.example.orderservice.api.response;

import com.example.orderservice.application.dto.OrderIntoDto;
import com.example.orderservice.application.dto.PaymentMethodDto;
import com.example.orderservice.application.dto.UserAddressDto;
import lombok.Builder;

@Builder
public record OrderCreateResponse(Long orderId, PaymentMethodDto paymentMethodDto, UserAddressDto userAddressDto) {
    public static OrderCreateResponse from(OrderIntoDto orderIntoDto) {
        return OrderCreateResponse.builder()
                .orderId(orderIntoDto.getOrderId())
                .paymentMethodDto(orderIntoDto.getPaymentMethod())
                .userAddressDto(orderIntoDto.getUserAddress())
                .build();
    }
}
