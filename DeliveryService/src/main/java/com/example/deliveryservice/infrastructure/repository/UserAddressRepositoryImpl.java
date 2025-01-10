package com.example.deliveryservice.infrastructure.repository;

import com.example.deliveryservice.application.repository.UserAddressRepository;
import com.example.deliveryservice.domain.UserAddress;
import com.example.deliveryservice.domain.exception.DeliveryException;
import com.example.deliveryservice.domain.exception.ErrorCode;
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

    @Override
    public UserAddress findById(Long id) {
        UserAddressEntity userAddressEntity = userAddressJpaRepository.findById(id)
                .orElseThrow(() -> new DeliveryException(ErrorCode.USER_ADDRESS_NOT_EXIST, "존재하지 않는 사용자 주소입니다. id: %s".formatted(id)));
        return UserAddress.from(userAddressEntity);
    }

    @Override
    public UserAddress findByUserId(Long userId) {
        UserAddressEntity userAddressEntity = userAddressJpaRepository.findByUserId(userId).stream().findFirst()
                .orElseThrow(() -> new DeliveryException(ErrorCode.USER_ADDRESS_NOT_EXIST, "존재하지 않는 사용자 주소입니다. userId: %s".formatted(userId)));
        return UserAddress.from(userAddressEntity);
    }


}
