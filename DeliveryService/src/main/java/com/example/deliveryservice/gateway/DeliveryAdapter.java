package com.example.deliveryservice.gateway;

public interface DeliveryAdapter {
    Long processDelivery(String pruductName, Long productCount, String address);
}
