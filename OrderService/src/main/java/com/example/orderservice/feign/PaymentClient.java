package com.example.orderservice.feign;

import com.example.orderservice.application.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentClient", url = "http://localhost:8085/payment/v1")
public interface PaymentClient {

    @GetMapping("/payments/{paymentId}")
    public PaymentDto getPayment(@PathVariable(value = "paymentId") Long paymentId);

    @GetMapping("/payment/v1/users/{userId}/first/method")
    public PaymentMethodDto getPaymentMethod(@PathVariable(value = "userId") Long userId);

    @PostMapping("/payment/v1/process")
    public PaymentDto processPayment(@RequestBody PaymentRegisterDto rq);

}
