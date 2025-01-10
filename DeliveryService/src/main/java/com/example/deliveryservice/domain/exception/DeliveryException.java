package com.example.deliveryservice.domain.exception;

import lombok.Getter;

@Getter
public class DeliveryException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;

    public DeliveryException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
