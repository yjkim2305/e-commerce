package com.example.searchservice.consumer;

import com.example.searchservice.application.SearchService;
import com.example.searchservice.consumer.dto.KafkaProductTagsMessage;
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
public class KafkaConcertConsumer {

    private final ObjectMapper objectMapper;
    private final SearchService searchService;

    @KafkaListener(topics = "product_tags_added")
    public void consumeTagAdded(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<String, String> consumer){
        try {
            KafkaProductTagsMessage message = objectMapper.readValue(data.value(), KafkaProductTagsMessage.class);
            searchService.addTagCache(message.sellerProductId(), message.tags());
            acknowledgment.acknowledge();
            log.info("Processed message: {}", message);
        } catch (Exception e) {
            log.error("Failed to process message: {}", data.value(), e);
        }
    }

    @KafkaListener(topics = "product_tags_removed")
    public void consumeTagRemoved(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<String, String> consumer){
        try {
            KafkaProductTagsMessage message = objectMapper.readValue(data.value(), KafkaProductTagsMessage.class);
            searchService.removeTagCache(message.sellerProductId(), message.tags());
            acknowledgment.acknowledge();
            log.info("Processed message: {}", message);
        } catch (Exception e) {
            log.error("Failed to process message: {}", data.value(), e);
        }
    }


}

