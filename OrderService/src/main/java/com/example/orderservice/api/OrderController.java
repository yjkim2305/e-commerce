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
        orderService.test();
        return null;
    }

    @PostMapping("/order/v1/process")
    public ProductOrder process(@RequestBody OrderProcessRequest rq) {
        return ProductOrder.builder().build();
    }

    @GetMapping("/order/v1/users/{userId}/orders")
    public List<ProductOrder> getUserOrders(@PathVariable(value = "userId") Long userId) {
        orderService.test();
        return List.of(ProductOrder.builder().build());
    }

    @GetMapping("/order/v1/orders/{orderId}")
    public ProductOrderDetailResponse getOrder(@PathVariable(value = "orderId") Long orderId) {
        return new ProductOrderDetailResponse(1L, 1L, 1L, 1L, 1L, OrderStatus.DELIVERY_REQUESTED, "", "");
    }


}
