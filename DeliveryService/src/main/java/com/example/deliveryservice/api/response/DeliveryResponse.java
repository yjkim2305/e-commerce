package com.example.deliveryservice.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record DeliveryResponse(boolean success, String comment) {
}
