package com.example.memberservice.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record UserResponse(boolean success, String comment) {
}
