package com.example.orderservice.consumer;

import com.example.orderservice.application.service.OrderService;
import com.example.orderservice.feign.CategoryClient;
import com.example.orderservice.kafka.KafkaMessageProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import({KafkaOrderConsumerTest.class})
class KafkaOrderConsumerTest {

    @Autowired
    private OrderService orderService;

    @MockitoBean
    CategoryClient categoryClient;

    @MockitoBean
    KafkaMessageProducer kafkaMessageProducer;

    @Autowired
    KafkaOrderConsumer kafkaOrderConsumer;

    @Test
    void consumePaymentResultTest() {

    }
}