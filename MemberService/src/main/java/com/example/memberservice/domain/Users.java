package com.example.memberservice.domain;

import com.example.memberservice.infrastructure.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Users {
    private Long id;
    private String loginId;
    private String userName;

    public void modifyUserName(String userName) {
        this.userName = userName;
    }

    public static Users from(UserEntity userEntity) {
        return Users.builder()
                .id(userEntity.getId())
                .loginId(userEntity.getLoginId())
                .userName(userEntity.getUserName())
                .build();
    }

    public static Users of(String loginId, String userName) {
        return Users.builder()
                .loginId(loginId)
                .userName(userName)
                .build();
    }
}
