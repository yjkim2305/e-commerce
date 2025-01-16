package com.example.orderservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserAddressDto {
    private Long id;
    private Long userId;
    private String address;
    private String alias;
}
