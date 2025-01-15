package com.example.searchservice.consumer.dto;

import lombok.Builder;

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
