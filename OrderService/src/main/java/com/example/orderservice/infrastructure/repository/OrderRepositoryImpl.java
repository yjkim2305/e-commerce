package com.example.orderservice.infrastructure.repository;

import com.example.orderservice.application.repository.OrderRepository;
import com.example.orderservice.domain.ProductOrder;
import com.example.orderservice.domain.exception.ErrorCode;
import com.example.orderservice.domain.exception.OrderException;
import com.example.orderservice.infrastructure.entity.ProductOrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public ProductOrder save(ProductOrder order) {
        return ProductOrder.from(orderJpaRepository.save(ProductOrderEntity.toEntity(order)));
    }

    @Override
    public ProductOrder findById(Long id) {
        return ProductOrder.from(orderJpaRepository.findById(id).orElseThrow(() ->
                new OrderException(ErrorCode.ORDER_NOT_EXIST, "진행되지 않은 주문건입니다. id: %s".formatted(id))));
    }

    @Override
    public List<ProductOrder> findByUserId(Long userId) {
        return orderJpaRepository.findByUserId(userId).stream()
                .map(ProductOrder::from)
                .toList();
    }
}
