package com.example.deliveryservice.api;

import com.example.deliveryservice.api.request.DeliveryRegisterRequest;
import com.example.deliveryservice.api.request.UserAddressRegisterRequest;
import com.example.deliveryservice.application.service.DeliveryService;
import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.domain.UserAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/delivery/v1/address")
    public UserAddress registerAddress(@RequestBody UserAddressRegisterRequest rq) {
        return deliveryService.addUserAddress(rq.userId(), rq.address(), rq.alias());
    }

//    @PostMapping("/delivery/v1/process")
//    public Delivery processDelivery(@RequestBody DeliveryRegisterRequest rq) {
//        return deliveryService.processDelivery(rq.orderId(), rq.productName(), rq.productCount(), rq.address());
//    }

    @GetMapping("/delivery/v1/deliveries/{deliveryId}")
    public Delivery getDelivery(@PathVariable(value = "deliveryId") Long deliveryId) {
        return deliveryService.getDelivery(deliveryId);
    }

    @GetMapping("/delivery/v1/address/{addressId}")
    public UserAddress getAddress(@PathVariable(value = "addressId") Long addressId) {
        return deliveryService.getAddress(addressId);
    }

    @GetMapping("/delivery/v1/users/{userId}/first/address")
    public UserAddress getFirstAddress(@PathVariable(value = "userId") Long userId) {
        return deliveryService.getAddress(userId);
    }
}
