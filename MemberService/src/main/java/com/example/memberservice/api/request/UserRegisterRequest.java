package com.example.memberservice.api.request;

import lombok.Getter;


public record UserRegisterRequest(String loginId, String userName) {
}
