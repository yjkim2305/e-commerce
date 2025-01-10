package com.example.deliveryservice;

import com.example.deliveryservice.api.response.DeliveryResponse;
import com.example.deliveryservice.domain.exception.DeliveryException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RequiredArgsConstructor
public class DeliveryControllerAdvice {

    @ExceptionHandler(DeliveryException.class)
    public DeliveryResponse handleException(DeliveryException e) {
        return new DeliveryResponse(false, e.getErrorCode().getMessage());
    }
}
