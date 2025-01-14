package com.example.orderservice.application.repository;

import com.example.orderservice.domain.ProductOrder;

import java.util.List;

public interface OrderRepository {
    ProductOrder save(ProductOrder order);
    ProductOrder findById(Long id);
    List<ProductOrder> findByUserId(Long userId);
}
