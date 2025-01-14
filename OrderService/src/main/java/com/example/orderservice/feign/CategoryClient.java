package com.example.orderservice.feign;

import com.example.orderservice.application.dto.ProductDecreaseStockCountDto;
import com.example.orderservice.application.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "categoryClient", url = "http://localhost:8080/category/v1")
public interface CategoryClient {

    @GetMapping(value = "/products/{productId}")
    ProductDto getProductById(@PathVariable(value = "productId") Long productId);

    @PostMapping("/products/{productId}/decrease/count")
    public void decreaseStockCount(@PathVariable(value = "productId") Long productId
            , @RequestBody ProductDecreaseStockCountDto productDecreaseStockCountDto);

}
