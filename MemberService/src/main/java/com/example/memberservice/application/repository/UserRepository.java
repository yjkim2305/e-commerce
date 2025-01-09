package com.example.memberservice.application.repository;

import com.example.memberservice.domain.Users;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    Users save(Users users);
    Users findById(Long id);
    Users findByLoginId(String loginId);
}
