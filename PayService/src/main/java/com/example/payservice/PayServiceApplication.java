package com.example.payservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-pay");
        SpringApplication.run(PayServiceApplication.class, args);
    }

}
