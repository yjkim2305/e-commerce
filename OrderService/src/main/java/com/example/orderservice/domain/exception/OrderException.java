package com.example.orderservice.domain.exception;

import lombok.Getter;

@Getter
public class OrderException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;

    public OrderException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
