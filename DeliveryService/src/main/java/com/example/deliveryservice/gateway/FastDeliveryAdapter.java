package com.example.deliveryservice.gateway;

public class FastDeliveryAdapter implements DeliveryAdapter {
    @Override
    public Long processDelivery(String pruductName, Long productCount, String address) {
        return Math.round(Math.random() * 10000000);
    }
}
