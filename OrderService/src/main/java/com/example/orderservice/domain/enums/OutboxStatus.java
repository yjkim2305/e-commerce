package com.example.orderservice.domain.enums;

import lombok.Getter;

@Getter
public enum OutboxStatus {

    INIT("대기"),
    PUBLISHED("발행 완료");

    private final String value;

    OutboxStatus(String value) {
        this.value = value;
    }
}
