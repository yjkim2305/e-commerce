package com.example.categoryservice.domain.exception;

import lombok.Getter;

@Getter
public class CategoryException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;

    public CategoryException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
