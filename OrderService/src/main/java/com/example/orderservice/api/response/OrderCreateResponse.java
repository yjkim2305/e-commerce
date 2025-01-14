package com.example.orderservice.api.response;

import com.example.orderservice.domain.dto.PaymentMethodDto;
import com.example.orderservice.domain.dto.UserAddressDto;

public record OrderCreateResponse(Long orderId, PaymentMethodDto paymentMethodDto, UserAddressDto userAddressDto) {
}
