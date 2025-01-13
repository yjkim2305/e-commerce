package com.example.categoryservice.application.repository;

import com.example.categoryservice.domain.Product;

public interface ProductRepository {
    Product save(Product product);
    Product findById(Long id);
    void deleteById(Long id);
}
