package com.example.deliveryservice.consumer;

import com.example.deliveryservice.application.service.DeliveryService;
import com.example.deliveryservice.consumer.dto.KafkaDeliveryProcessMessage;
import com.example.deliveryservice.consumer.dto.KafkaDeliveryStatusMessage;
import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.kafka.KafkaMessageProducer;
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
public class KafkaDeliveryConsumer {

    private final ObjectMapper objectMapper;
    private final DeliveryService deliveryService;
    private final KafkaMessageProducer kafkaMessageProducer;


    @KafkaListener(topics = "delivery_request")
    public void consumeDeliveryRequest(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<String, String> consumer){
        try {

            KafkaDeliveryProcessMessage message = objectMapper.readValue(data.value(), KafkaDeliveryProcessMessage.class);
            Delivery delivery = deliveryService.processDelivery(
                    message.getOrderId(),
                    message.getProductName(),
                    message.getProductCount(),
                    message.getAddress()
            );

            kafkaMessageProducer.send("delivery_status_update", KafkaDeliveryStatusMessage.of(delivery.getOrderId(), delivery.getId(), delivery.getStatus()));
            acknowledgment.acknowledge();
            log.info("Processed message: {}", message);
        } catch (Exception e) {
            log.error("Failed to process message: {}", data.value(), e);
        }
    }





}

