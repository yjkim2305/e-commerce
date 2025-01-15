package com.example.categoryservice.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public record KafkaProductTagsMessage(Long sellerProductId, List<String> tags) {
    public static KafkaProductTagsMessage of(Long sellerProductId, List<String> tags) {
        return KafkaProductTagsMessage.builder()
                .sellerProductId(sellerProductId)
                .tags(tags)
                .build();
    }
}
