package com.example.categoryservice.application.repository;

import com.example.categoryservice.domain.SellerProduct;

import java.util.List;

public interface SellerProductRepository {
    SellerProduct save(SellerProduct sellerProduct);
    List<SellerProduct> findBySellerId(Long sellerId);
    void deleteById(Long id);
}
