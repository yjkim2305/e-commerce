package com.example.memberservice.api.request;

import lombok.Getter;

@Getter
public class UserRegisterRequest {
    private String loginId;
    private String userName;
}
