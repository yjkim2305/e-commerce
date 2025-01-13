package com.example.categoryservice.api.request;

import java.util.List;

public record ProductRegisterRequest(Long sellerId, String name, String description, Long price, Long stockCount, List<String> tags) {
}
