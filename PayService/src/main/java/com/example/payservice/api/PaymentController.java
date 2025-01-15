package com.example.payservice.api;

import com.example.payservice.api.request.PaymentMethodRegisterRequest;
import com.example.payservice.api.request.PaymentRegisterRequest;
import com.example.payservice.application.service.PaymentService;
import com.example.payservice.domain.Payment;
import com.example.payservice.domain.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment/v1/methods")
    public PaymentMethod registerPaymentMethod(@RequestBody PaymentMethodRegisterRequest rq) {
        return paymentService.registerPaymentMethod(
                rq.userId(), rq.paymentMethodType(), rq.creditCardNumber()
        );
    }

//    @PostMapping("/payment/v1/process")
//    public Payment processPayment(@RequestBody PaymentRegisterRequest rq) {
//        return paymentService.processPayment(
//                rq.orderId(),
//                rq.userId(),
//                rq.amountKRW(),
//                rq.paymentMethodId()
//        );
//    }

    @GetMapping("/payment/v1/users/{userId}/first/method")
    public PaymentMethod getPaymentMethod(@PathVariable(value = "userId") Long userId) {
        return paymentService.getPaymentMehodByUser(userId);
    }

    @GetMapping("/payment/v1/payments/{paymentId}")
    public Payment getPayment(@PathVariable(value = "paymentId") Long paymentId) {
        return paymentService.getPayment(paymentId);
    }
}
