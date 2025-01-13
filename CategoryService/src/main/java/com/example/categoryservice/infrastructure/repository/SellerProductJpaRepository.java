package com.example.categoryservice.infrastructure.repository;

import com.example.categoryservice.infrastructure.entity.mysql.SellerProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerProductJpaRepository extends JpaRepository<SellerProductEntity, Long> {
    List<SellerProductEntity> findBySellerId(Long sellerId);
}
