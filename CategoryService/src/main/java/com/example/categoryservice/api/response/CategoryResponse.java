package com.example.categoryservice.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record CategoryResponse(boolean success, String comment) {
}
