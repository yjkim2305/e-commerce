package com.example.payservice.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    PAYMENT_NOT_EXIST("진행되지 않은 결제 건입니다."),
    PAYMENT_MEHTOD_NOT_EXIST("존재하지 않는 결제 수단입니다."),
    USER_PAYMENT_MEHTOD_NOT_EXIST("사용자의 결제 수단이 존재하지 않습니다."),
    UNSUPORT_PAYMENT_METHOD("지원하지 않는 결제 수단입니다.")
    ;

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }
}
