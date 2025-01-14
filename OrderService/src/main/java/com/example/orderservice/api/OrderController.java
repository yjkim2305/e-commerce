package com.example.orderservice.api;

import com.example.orderservice.api.request.OrderCreateRequest;
import com.example.orderservice.api.request.OrderProcessRequest;
import com.example.orderservice.api.response.OrderCreateResponse;
import com.example.orderservice.api.response.ProductOrderDetailResponse;
import com.example.orderservice.application.service.OrderService;
import com.example.orderservice.domain.ProductOrder;
import com.example.orderservice.domain.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/v1/create/info")
    public OrderCreateResponse createOrderInfo(@RequestBody OrderCreateRequest rq) {
        return OrderCreateResponse.from(orderService.createOrderInfo(rq.userId(), rq.productId(), rq.count()));
    }

    @PostMapping("/order/v1/process")
    public ProductOrder process(@RequestBody OrderProcessRequest rq) {
        return orderService.process(rq.orderId(), rq.paymentMethodId(), rq.addressId());
    }

    @GetMapping("/order/v1/users/{userId}/orders")
    public List<ProductOrder> getUserOrders(@PathVariable(value = "userId") Long userId) {
        return orderService.getUserOrders(userId);
    }

    @GetMapping("/order/v1/orders/{orderId}")
    public ProductOrderDetailResponse getOrder(@PathVariable(value = "orderId") Long orderId) {
        return ProductOrderDetailResponse.from(orderService.getOrderDetail(orderId));
    }


}
