package com.example.orderservice.application.repository;

import com.example.orderservice.domain.OrderOutbox;

public interface OrderOutboxRepository {
    OrderOutbox save(OrderOutbox orderOutbox);
}
