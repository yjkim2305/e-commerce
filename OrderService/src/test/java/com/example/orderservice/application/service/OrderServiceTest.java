package com.example.orderservice.application.service;

import com.example.orderservice.application.dto.*;
import com.example.orderservice.application.repository.OrderRepository;
import com.example.orderservice.domain.ProductOrder;
import com.example.orderservice.domain.enums.DeliveryStatus;
import com.example.orderservice.domain.enums.OrderStatus;
import com.example.orderservice.domain.enums.PaymentMethodType;
import com.example.orderservice.domain.enums.PaymentStatus;
import com.example.orderservice.feign.CategoryClient;
import com.example.orderservice.feign.DeliveryClient;
import com.example.orderservice.feign.PaymentClient;
import com.example.orderservice.infrastructure.repository.OrderJpaRepository;
import com.example.orderservice.kafka.KafkaMessageProducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import({OrderService.class})
class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @MockitoBean
    CategoryClient categoryClient;

    @MockitoBean
    DeliveryClient deliveryClient;

    @MockitoBean
    PaymentClient paymentClient;

    @MockitoBean
    KafkaMessageProducer kafkaMessageProducer;

    @Autowired
    OrderService orderService;

    @Test
    void createOrderInfoTest() {
        //given
        PaymentMethodDto paymentMethod = PaymentMethodDto.builder()
                .paymentMethodType(PaymentMethodType.CREDIT_CARD)
                .build();

        UserAddressDto address = UserAddressDto.builder()
                .address("서울시 구로구")
                .build();

        when(paymentClient.getPaymentMethod(1L)).thenReturn(paymentMethod);
        when(deliveryClient.getFirstAddress(1L)).thenReturn(address);
        //when

        OrderIntoDto order = orderService.createOrderInfo(1L, 1L, 2L);

        //then
        assertNotNull(order.getOrderId());
        assertEquals(paymentMethod, order.getPaymentMethod());
        assertEquals(address, order.getUserAddress());

        ProductOrder order1 = orderRepository.findById(order.getOrderId());
        assertEquals(order1.getOrderStatus(), OrderStatus.INITIATED);
    }

    @Test
    void process() {
        //given
        ProductOrder order = orderRepository.save(
                ProductOrder.of(
                        1L,
                        1L,
                        1L,
                        OrderStatus.INITIATED,
                        null,
                        null,
                        null
                ));

        UserAddressDto address = UserAddressDto.builder()
                .address("서울시 강남구")
                .build();


        when(categoryClient.getProductById(order.getProductId())).thenReturn(
                ProductDto.builder()
                        .price(100L)
                        .build());



        when(deliveryClient.getAddress(1L)).thenReturn(address);

        //when
        ProductOrder order1 = orderService.process(order.getId(), 1L, 1L);


        //then
        assertEquals(order1.getDeliveryAddress(), address.getAddress());
        verify(kafkaMessageProducer, times(1)).send(
                eq("payment_request"),
                any(PaymentRegisterDto.class)
        );

    }

    @Test
    void getUserOrdersTest() {
        Long userId = 2L;
        ProductOrder order1 = ProductOrder.of(
                userId,
                100L,
                1L,
                OrderStatus.INITIATED,
                null,
                null,
                null
        );

        ProductOrder order2 = ProductOrder.of(
                userId,
                110L,
                1L,
                OrderStatus.INITIATED,
                null,
                null,
                null
        );

        orderRepository.save(order1);
        orderRepository.save(order2);

        List<ProductOrder> orders = orderService.getUserOrders(userId);

        assertEquals(orders.size(), 2);
        assertEquals(100L, orders.get(0).getProductId());
        assertEquals(110L, orders.get(1).getProductId());
    }

    @Test
    void getOrderDetailsTest() {
        ProductOrder order1 = ProductOrder.of(
                1L,
                1L,
                1L,
                OrderStatus.DELIVERY_REQUESTED,
                10L,
                11L,
                null
        );

        ProductOrder saved = orderRepository.save(order1);

        when(paymentClient.getPayment(10L)).thenReturn(
                PaymentDto.builder()
                        .paymentStatus(PaymentStatus.COMPLETED)
                        .build()
        );

        when(deliveryClient.getDelivery(11L)).thenReturn(
                DeliveryDto.builder()
                        .status(DeliveryStatus.IN_DELIVERY)
                        .build()
        );

        ProductOrderDetailDto orderDetail = orderService.getOrderDetail(saved.getId());

        assertEquals(10L, orderDetail.getPaymentId());
        assertEquals(11L, orderDetail.getDeliveryId());
        assertEquals(PaymentStatus.COMPLETED.name(), orderDetail.getPaymentStatus());
        assertEquals(DeliveryStatus.IN_DELIVERY.name(), orderDetail.getDeliveryStatus());

    }
}