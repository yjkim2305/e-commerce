package com.example.deliveryservice.domain;

import com.example.deliveryservice.infrastructure.entity.UserAddressEntity;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAddress {
    private Long id;
    private Long userId;
    private String address;
    private String alias;

    public static UserAddress from(UserAddressEntity userAdressEntity) {
        return UserAddress.builder()
                .id(userAdressEntity.getId())
                .userId(userAdressEntity.getUserId())
                .address(userAdressEntity.getAddress())
                .alias(userAdressEntity.getAlias())
                .build();
    }

    public static UserAddress of(Long userId, String address, String alias) {
        return UserAddress.builder()
                .userId(userId)
                .address(address)
                .alias(alias)
                .build();
    }
}
