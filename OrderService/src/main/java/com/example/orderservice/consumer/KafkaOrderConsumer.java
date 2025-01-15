package com.example.orderservice.consumer;

import com.example.orderservice.application.dto.ProductDecreaseStockCountDto;
import com.example.orderservice.application.dto.ProductDto;
import com.example.orderservice.application.service.OrderService;
import com.example.orderservice.consumer.dto.KafkaDeliveryRequestMessage;
import com.example.orderservice.consumer.dto.KafkaDeliveryStatusMessage;
import com.example.orderservice.consumer.dto.KafkaPaymentResultMessage;
import com.example.orderservice.domain.ProductOrder;
import com.example.orderservice.domain.enums.DeliveryStatus;
import com.example.orderservice.feign.CategoryClient;
import com.example.orderservice.kafka.KafkaMessageProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class KafkaOrderConsumer {

    private final ObjectMapper objectMapper;
    private final OrderService orderService;
    private final CategoryClient categoryClient;
    private final KafkaMessageProducer kafkaMessageProducer;


    @KafkaListener(topics = "payment_result")
    public void consumePaymentResult(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<String, String> consumer) {
        try {

            KafkaPaymentResultMessage message = objectMapper.readValue(data.value(), KafkaPaymentResultMessage.class);

            ProductOrder order = orderService.deliveryRequest(message.getOrderId());
            ProductDto product = categoryClient.getProductById(order.getProductId());


            kafkaMessageProducer.send("delivery_request",
                    KafkaDeliveryRequestMessage.of(
                            order.getId(),
                            product.getName(),
                            order.getCount(),
                            order.getDeliveryAddress()
                    ));
            acknowledgment.acknowledge();
            log.info("Processed message: {}", message);
        } catch (Exception e) {
            log.error("Failed to process message: {}", data.value(), e);
        }
    }

    @KafkaListener(topics = "delivery_status_update")
    public void consumeDeliveryStatusUpdate(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<String, String> consumer) {
        try {

            KafkaDeliveryStatusMessage message = objectMapper.readValue(data.value(), KafkaDeliveryStatusMessage.class);

            if (message.getDeliveryStatus().equals(DeliveryStatus.REQUESTED)) {
                //상품 재고 감소
                orderService.decreaseStockCount(message.getOrderId());
            }

            acknowledgment.acknowledge();
            log.info("Processed message: {}", message);
        } catch (Exception e) {
            log.error("Failed to process message: {}", data.value(), e);
        }
    }
}

