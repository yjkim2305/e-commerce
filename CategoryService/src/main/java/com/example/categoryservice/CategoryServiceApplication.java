package com.example.categoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CategoryServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-category");
        SpringApplication.run(CategoryServiceApplication.class, args);
    }

}
