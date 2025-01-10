package com.example.payservice.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record PaymentResponse(boolean success, String comment) {
}
