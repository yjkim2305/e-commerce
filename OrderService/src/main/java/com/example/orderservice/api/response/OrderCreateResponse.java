package com.example.orderservice.api.response;

import com.example.orderservice.application.dto.PaymentMethodDto;
import com.example.orderservice.application.dto.UserAddressDto;

public record OrderCreateResponse(Long orderId, PaymentMethodDto paymentMethodDto, UserAddressDto userAddressDto) {
}
