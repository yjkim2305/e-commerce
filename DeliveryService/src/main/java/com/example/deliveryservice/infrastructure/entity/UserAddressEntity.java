package com.example.deliveryservice.infrastructure.entity;

import com.example.deliveryservice.domain.UserAddress;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Table(name = "user_address", indexes = {@Index(name = "idx_userId", columnList = "userId")})
public class UserAddressEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String address;
    private String alias;

    public static UserAddressEntity toEntity(UserAddress userAddress) {
        return UserAddressEntity.builder()
                .id(userAddress.getId())
                .userId(userAddress.getUserId())
                .address(userAddress.getAddress())
                .alias(userAddress.getAlias())
                .build();
    }
}
