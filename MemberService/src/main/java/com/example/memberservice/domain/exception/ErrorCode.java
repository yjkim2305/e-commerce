package com.example.memberservice.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_NOT_EXIST("존재하지 않는 사용자입니다.");

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }
}
