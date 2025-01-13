package com.example.categoryservice.infrastructure.repository;

import com.example.categoryservice.infrastructure.entity.cassandra.ProductEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCassandraRepository extends CassandraRepository<ProductEntity, Long> {
}
