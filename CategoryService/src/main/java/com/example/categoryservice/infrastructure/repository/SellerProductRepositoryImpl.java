package com.example.categoryservice.infrastructure.repository;

import com.example.categoryservice.application.repository.SellerProductRepository;
import com.example.categoryservice.domain.SellerProduct;
import com.example.categoryservice.infrastructure.entity.mysql.SellerProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SellerProductRepositoryImpl implements SellerProductRepository {

    private final SellerProductJpaRepository sellerProductJpaRepository;

    @Override
    public SellerProduct save(SellerProduct sellerProduct) {
        return SellerProduct.from(sellerProductJpaRepository.save(SellerProductEntity.toEntity(sellerProduct)));
    }

    @Override
    public List<SellerProduct> findBySellerId(Long sellerId) {
        return SellerProduct.fromByEntityList(sellerProductJpaRepository.findBySellerId(sellerId));
    }

    @Override
    public void deleteById(Long id) {
        sellerProductJpaRepository.deleteById(id);
    }
}
