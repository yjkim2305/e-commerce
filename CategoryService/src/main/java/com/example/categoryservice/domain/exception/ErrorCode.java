package com.example.categoryservice.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SELLER_NOT_EXIST("존재하지 않는 판매자입니다.");

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }
}
