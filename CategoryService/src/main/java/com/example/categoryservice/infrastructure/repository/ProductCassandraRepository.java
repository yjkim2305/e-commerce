package com.example.categoryservice.infrastructure.repository;

import com.example.categoryservice.infrastructure.entity.cassandra.ProductEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCassandraRepository extends CassandraRepository<ProductEntity, Long> {

    @Query("UPDATE product SET stock_count = stock_count - :count WHERE id = :productId IF stock_count >= :count")
    boolean decreaseStock(@Param("productId") Long productId, @Param("count") Long count);
}
