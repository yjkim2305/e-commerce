package com.example.categoryservice.infrastructure.repository;

import com.example.categoryservice.application.repository.ProductRepository;
import com.example.categoryservice.domain.Product;
import com.example.categoryservice.domain.exception.CategoryException;
import com.example.categoryservice.domain.exception.ErrorCode;
import com.example.categoryservice.infrastructure.entity.cassandra.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCassandraRepository productCassandraRepository;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productCassandraRepository.save(ProductEntity.toEntity(product));
        return Product.from(productEntity);
    }

    @Override
    public Product findById(Long id) {
        ProductEntity productEntity = productCassandraRepository.findById(id).orElseThrow(() ->
                new CategoryException(ErrorCode.PRODUCT_NOT_EXIST, "존재하지 않는 상품입니다. id: %s".formatted(id)));
        return Product.from(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        productCassandraRepository.deleteById(id);
    }
}
