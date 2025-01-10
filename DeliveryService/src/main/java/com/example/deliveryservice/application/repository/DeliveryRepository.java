package com.example.deliveryservice.application.repository;

import com.example.deliveryservice.domain.Delivery;

public interface DeliveryRepository {

    Delivery save(Delivery delivery);
}
