package com.example.payservice.consumer;

import com.example.payservice.application.service.PaymentService;
import com.example.payservice.consumer.dto.KafkaPaymentProcessMessage;
import com.example.payservice.consumer.dto.KafkaPaymentResultMessage;
import com.example.payservice.domain.Payment;
import com.example.payservice.kafka.KafkaMessageProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
public class KafkaPayConsumer {

    private final ObjectMapper objectMapper;
    private final PaymentService paymentService;
    private final KafkaMessageProducer kafkaMessageProducer;

    @KafkaListener(topics = "ecommerce.payment_request")
    public void consumePayRequest(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<String, String> consumer) throws JsonProcessingException {

        JsonNode root = objectMapper.readTree(data.value());
        String operation = root.path("payload").path("op").asText();
        log.info(data.value());
        if ("c".equals(operation)) {
            JsonNode afterNode = root.path("payload").path("after");
            String payload = afterNode.path("payload").asText();
            try {

                KafkaPaymentProcessMessage message = objectMapper.readValue(payload, KafkaPaymentProcessMessage.class);
                Payment payment = paymentService.processPayment(
                        message.getOrderId(),
                        message.getUserId(),
                        message.getAmountKRW(),
                        message.getPaymentMethodId()
                );

                // ExternalPaymentAdapter를 사용한 외부 연동도 EDA로 수행될 수 있음.

                kafkaMessageProducer.send("payment_result", KafkaPaymentResultMessage.of(payment.getOrderId(), payment.getId(), payment.getPaymentStatus()));
                acknowledgment.acknowledge();
                log.info("Processed message: {}", message);
            } catch (Exception e) {
                log.error("Failed to process message: {}", data.value(), e);
            }
        } else {
            acknowledgment.acknowledge();
        }

    }








}

