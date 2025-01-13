package com.example.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-search");
        SpringApplication.run(SearchServiceApplication.class, args);
    }

}
