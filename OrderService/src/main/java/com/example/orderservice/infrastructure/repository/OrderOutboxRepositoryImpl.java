package com.example.orderservice.infrastructure.repository;

import com.example.orderservice.application.repository.OrderOutboxRepository;
import com.example.orderservice.domain.OrderOutbox;
import com.example.orderservice.infrastructure.entity.OrderOutboxEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderOutboxRepositoryImpl implements OrderOutboxRepository {

    private final OrderOutboxJpaRepository repository;

    @Override
    public OrderOutbox save(OrderOutbox orderOutbox) {
        return OrderOutbox.from(repository.save(OrderOutboxEntity.toEntity(orderOutbox)));
    }
}
