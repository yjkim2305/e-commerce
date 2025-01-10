package com.example.payservice.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    PAYMENT_MEHTOD_NOT_EXIST("존재하지 않는 결제 수단입니다."),
    USUPORT_PAYMENT_METHOD("지원하지 않는 결제 수단입니다.")
    ;

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }
}
