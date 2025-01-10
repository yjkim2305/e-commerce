package com.example.deliveryservice.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DELIVERY_NOT_EXIST("존재하지 않는 배송입니다."),
    USER_ADDRESS_NOT_EXIST("존재하지 않는 사용자 주소입니다.")
    ;

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }
}
