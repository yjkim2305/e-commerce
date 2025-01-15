package com.example.categoryservice.application.service;

import com.example.categoryservice.application.dto.KafkaProductTagsMessage;
import com.example.categoryservice.application.repository.ProductRepository;
import com.example.categoryservice.application.repository.SellerProductRepository;
import com.example.categoryservice.domain.Product;
import com.example.categoryservice.domain.SellerProduct;
import com.example.categoryservice.infrastructure.entity.cassandra.ProductEntity;
import com.example.categoryservice.infrastructure.repository.ProductCassandraRepository;
import com.example.categoryservice.kafka.KafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ProductRepository productRepository;
    private final SellerProductRepository sellerProductRepository;
    private final KafkaMessageProducer kafkaMessageProducer;

    public Product registerProduct(
            Long sellerId,
            String name,
            String description,
            Long price,
            Long stockCount,
            List<String> tags
    ) {
        SellerProduct sellerProduct = sellerProductRepository.save(SellerProduct.from(sellerId));

        kafkaMessageProducer.send("product_tags_added", KafkaProductTagsMessage.of(sellerProduct.getId(), tags));

        return productRepository.save(Product.of(sellerProduct.getId(), sellerId, name, description, price, stockCount, tags));
    }

    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId);

        kafkaMessageProducer.send("product_tags_removed", KafkaProductTagsMessage.of(product.getId(), product.getTags()));

        productRepository.deleteById(productId);
        sellerProductRepository.deleteById(productId);
    }

    public List<Product> getProductsBySellerId(Long sellerId) {
        return sellerProductRepository.findBySellerId(sellerId).stream()
                .map(item -> productRepository.findById(item.getId()))
                .toList();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public void decreaseStock(Long productId, Long stockCount) {
        //redisson try lock 구현
        Product product = productRepository.findById(productId);
        product.decreaseStockCount(stockCount);
        productRepository.save(product);
    }


}
