package com.example.deliveryservice.application.repository;

import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.domain.enums.DeliveryStatus;

import java.util.List;

public interface DeliveryRepository {
    Delivery save(Delivery delivery);
    Delivery findById(Long id);
    List<Delivery> findAllByStatus(DeliveryStatus status);
}
