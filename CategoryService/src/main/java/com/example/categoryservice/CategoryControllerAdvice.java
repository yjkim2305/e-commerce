package com.example.categoryservice;

import com.example.categoryservice.api.response.CategoryResponse;
import com.example.categoryservice.domain.exception.CategoryException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoryControllerAdvice {

    @ExceptionHandler
    public CategoryResponse handleException(CategoryException e) {
        return new CategoryResponse(false, e.getErrorCode().getMessage());
    }
}
