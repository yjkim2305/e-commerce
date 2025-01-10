package com.example.memberservice.application.service;

import com.example.memberservice.application.repository.UserRepository;
import com.example.memberservice.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public Users registerUser(String loginId, String userName) {
        return userRepository.save(Users.of(loginId, userName));
    }

    public Users modifyUser(Long userId, String userName) {
        Users users = userRepository.findById(userId);
        users.modifyUserName(userName);
        return userRepository.save(users);
    }

    public Users getUser(String loginId) {
        return userRepository.findByLoginId(loginId);
    }
}
