package com.example.orderservice.feign;

import com.example.orderservice.application.dto.DeliveryDto;
import com.example.orderservice.application.dto.DeliveryRegisterDto;
import com.example.orderservice.application.dto.UserAddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "deliveryClient", url = "http://localhost:8083/delivery/v1")
public interface DeliveryClient {
    @GetMapping("/users/{userId}/first/address")
    public UserAddressDto getFirstAddress(@PathVariable(value = "userId") Long userId);

    @GetMapping("/address/{addressId}")
    public UserAddressDto getAddress(@PathVariable(value = "addressId") Long addressId);

    @PostMapping("/process")
    public DeliveryDto processDelivery(@RequestBody DeliveryRegisterDto rq);

    @GetMapping("/deliveries/{deliveryId}")
    public DeliveryDto getDelivery(@PathVariable(value = "deliveryId") Long deliveryId);

}
