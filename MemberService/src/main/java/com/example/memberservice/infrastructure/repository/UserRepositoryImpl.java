package com.example.memberservice.infrastructure.repository;

import com.example.memberservice.application.repository.UserRepository;
import com.example.memberservice.domain.Users;
import com.example.memberservice.domain.exception.ErrorCode;
import com.example.memberservice.domain.exception.UserException;
import com.example.memberservice.infrastructure.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;


    @Override
    public Users save(Users users) {
        UserEntity userEntity = userJpaRepository.save(UserEntity.toEntity(users));
        return Users.from(userEntity);
    }

    @Override
    public Users findById(Long id) {
        return userJpaRepository.findById(id)
                .map(Users::from)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_EXIST, "사용자가 존재하지 않습니다. %s".formatted(id)));
    }

    @Override
    public Users findByLoginId(String loginId) {
        return userJpaRepository.findByLoginId(loginId)
                .map(Users::from)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_EXIST, "사용자가 존재하지 않습니다. %s".formatted(loginId)));
    }
}
