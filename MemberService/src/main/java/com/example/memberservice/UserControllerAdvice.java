package com.example.memberservice;

import com.example.memberservice.api.response.UserResponse;
import com.example.memberservice.domain.exception.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler
    public UserResponse handleException(UserException e) {
        return new UserResponse(false, e.getErrorCode().getMessage());
    }
}
