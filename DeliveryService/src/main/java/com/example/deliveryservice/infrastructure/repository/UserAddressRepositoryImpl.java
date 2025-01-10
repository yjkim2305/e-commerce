package com.example.deliveryservice.infrastructure.repository;

import com.example.deliveryservice.application.repository.UserAddressRepository;
import com.example.deliveryservice.domain.UserAddress;
import com.example.deliveryservice.infrastructure.entity.UserAddressEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserAddressRepositoryImpl implements UserAddressRepository {

    private final UserAddressJpaRepository userAddressJpaRepository;

    @Override
    public UserAddress save(UserAddress userAddress) {
        UserAddressEntity userAddressEntity = userAddressJpaRepository.save(UserAddressEntity.toEntity(userAddress));
        return UserAddress.from(userAddressEntity);
    }
}
