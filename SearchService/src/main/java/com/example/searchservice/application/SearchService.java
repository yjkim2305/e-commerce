package com.example.searchservice.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final RedisTemplate<String, String> redisTemplate;

    public void addTagCache(Long productId, List<String> tags) {
        tags.forEach( tag -> {
            redisTemplate.opsForSet().add(tag, productId.toString());
        });
    }

    public void removeTagCache(Long productId, List<String> tags) {
        tags.forEach( tag -> {
            redisTemplate.opsForSet().remove(tag, productId.toString());
        });
    }

    public List<Long> getProductIdsByTag(String tag) {
        return redisTemplate.opsForSet().members(tag) != null ?
                redisTemplate.opsForSet().members(tag).stream().map(Long::parseLong).toList()
                : Collections.emptyList();
    }
}
