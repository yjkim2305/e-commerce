package com.example.orderservice.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record OrderResponse(boolean success, String comment) {
}
