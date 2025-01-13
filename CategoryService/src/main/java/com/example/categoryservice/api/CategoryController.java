package com.example.categoryservice.api;

import com.example.categoryservice.api.request.ProductDecreaseStockCountRequest;
import com.example.categoryservice.api.request.ProductRegisterRequest;
import com.example.categoryservice.application.service.CategoryService;
import com.example.categoryservice.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category/v1/products")
    public Product registerProduct(@RequestBody ProductRegisterRequest rq) {
        return categoryService.registerProduct(
                rq.sellerId(),
                rq.name(),
                rq.description(),
                rq.price(),
                rq.stockCount(),
                rq.tags()
        );
    }

    @DeleteMapping("/category/v1/products/{productId}")
    public void deleteProduct(@PathVariable(value = "productId") Long productId) {
        categoryService.deleteProduct(productId);
    }

    @GetMapping("/category/v1/products/{productId}")
    public Product getProductById(@PathVariable(value = "productId") Long productId) throws Exception {
        return categoryService.getProductById(productId);
    }

    @GetMapping("/category/v1/sellers/{sellerId}/products")
    public List<Product> getProductsBySellerId (@PathVariable(value = "sellerId") Long sellerId) throws Exception {
        return categoryService.getProductsBySellerId(sellerId);
    }

    @PostMapping("/category/v1/products/{productId}/decrease/count")
    public Product decreaseStockCount(@PathVariable(value = "productId") Long productId
            , @RequestBody ProductDecreaseStockCountRequest rq) {
        return categoryService.decreaseStock(productId, rq.stockCount());
    }
}
