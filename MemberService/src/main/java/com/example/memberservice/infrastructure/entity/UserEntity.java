package com.example.memberservice.infrastructure.entity;

import com.example.memberservice.domain.Users;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String loginId;

    private String userName;

    public static UserEntity toEntity(Users user) {
        return UserEntity.builder()
                .id(user.getId())
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .build();
    }
}
