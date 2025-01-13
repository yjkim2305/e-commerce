package com.example.searchservice.api.request;

import java.util.List;

public record ProductTagsRegisterRequest(Long productId, List<String> tags) {
}
