package com.example.orderservice.infrastructure.repository;

import com.example.orderservice.domain.OrderOutbox;
import com.example.orderservice.infrastructure.entity.OrderOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderOutboxJpaRepository extends JpaRepository<OrderOutboxEntity, Long> {

}
