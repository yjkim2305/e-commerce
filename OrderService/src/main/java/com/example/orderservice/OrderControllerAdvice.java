package com.example.orderservice;

import com.example.orderservice.api.response.OrderResponse;
import com.example.orderservice.domain.exception.OrderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler(OrderException.class)
    public OrderResponse handlePaymentException(OrderException e) {
        return new OrderResponse(false, e.getErrorCode().getMessage());
    }
}
