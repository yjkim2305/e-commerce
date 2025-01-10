package com.example.deliveryservice.infrastructure.repository;

import com.example.deliveryservice.application.repository.DeliveryRepository;
import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.infrastructure.entity.DeliveryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final DeliveryJpaRepository deliveryJpaRepository;

    @Override
    public Delivery save(Delivery delivery) {
        DeliveryEntity deliveryEntity = deliveryJpaRepository.save(DeliveryEntity.toEntity(delivery));
        return Delivery.from(deliveryEntity);
    }
}
