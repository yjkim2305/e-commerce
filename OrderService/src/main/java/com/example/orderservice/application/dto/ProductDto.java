package com.example.orderservice.application.dto;

import java.util.List;

public class ProductDto {
    private Long id;
    private Long sellerId;
    private String name;
    private String description;
    private Long price;
    private Long stockCount;
    private List<String> tags;
}
