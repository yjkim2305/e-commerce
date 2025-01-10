package com.example.deliveryservice.infrastructure.repository;

import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.infrastructure.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryJpaRepository extends JpaRepository<DeliveryEntity, Long> {
    List<DeliveryEntity> findByOrderId(Long orderId);
}
