package com.example.orderservice.application.dto;

import lombok.Getter;

@Getter
public class UserAddressDto {
    private Long id;
    private Long userId;
    private String address;
    private String alias;
}
