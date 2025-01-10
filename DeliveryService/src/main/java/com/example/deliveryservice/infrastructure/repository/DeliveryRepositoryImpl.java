package com.example.deliveryservice.infrastructure.repository;

import com.example.deliveryservice.application.repository.DeliveryRepository;
import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.domain.enums.DeliveryStatus;
import com.example.deliveryservice.domain.exception.DeliveryException;
import com.example.deliveryservice.domain.exception.ErrorCode;
import com.example.deliveryservice.infrastructure.entity.DeliveryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final DeliveryJpaRepository deliveryJpaRepository;

    @Override
    public Delivery save(Delivery delivery) {
        DeliveryEntity deliveryEntity = deliveryJpaRepository.save(DeliveryEntity.toEntity(delivery));
        return Delivery.from(deliveryEntity);
    }

    @Override
    public Delivery findById(Long id) {
        DeliveryEntity deliveryEntity = deliveryJpaRepository.findById(id).orElseThrow(
                () -> new DeliveryException(ErrorCode.DELIVERY_NOT_EXIST, "존재하지 않는 배송입니다. id: %s".formatted(id)));
        return Delivery.from(deliveryEntity);
    }

    @Override
    public List<Delivery> findAllByStatus(DeliveryStatus status) {
        return Delivery.fromByEntity(deliveryJpaRepository.findAllByStatus(status));
    }
}
