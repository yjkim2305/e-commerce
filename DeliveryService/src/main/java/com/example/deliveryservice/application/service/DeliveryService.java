package com.example.deliveryservice.application.service;

import com.example.deliveryservice.application.repository.DeliveryRepository;
import com.example.deliveryservice.application.repository.UserAddressRepository;
import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.domain.UserAddress;
import com.example.deliveryservice.domain.enums.DeliveryStatus;
import com.example.deliveryservice.gateway.DeliveryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final UserAddressRepository userAddressRepository;
    private final DeliveryAdapter deliveryAdapter;

    public UserAddress addUserAddress(Long userId, String address, String alias) {
        return userAddressRepository.save(UserAddress.of(userId, address, alias));
    }

    public Delivery processDelivery(
            Long orderId,
            String productName,
            Long productCount,
            String address
    ) {
        Long refCode = deliveryAdapter.processDelivery(productName, productCount, address);
        return deliveryRepository.save(Delivery.of(
                orderId,
                productName,
                productCount,
                address,
                refCode,
                DeliveryStatus.REQUESTED
        ));
    }

    public Delivery getDelivery(Long deliveryId) {
        return deliveryRepository.findById(deliveryId);
    }

    public UserAddress getAddress(Long addressId) {
        return userAddressRepository.findById(addressId);
    }

    public UserAddress getUserAddress(Long userId) {
        return userAddressRepository.findByUserId(userId);
    }

}
