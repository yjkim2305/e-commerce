package com.example.orderservice.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_ORDER_NOT_EXIST("사용자의 주문이 존재하지 않습니다."),
    ORDER_NOT_EXIST("진행되지 않은 주문 건입니다.");

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }
}
