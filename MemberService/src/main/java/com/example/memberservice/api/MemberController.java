package com.example.memberservice.api;

import com.example.memberservice.api.request.UserModifyRequest;
import com.example.memberservice.api.request.UserRegisterRequest;
import com.example.memberservice.api.response.UserResponse;
import com.example.memberservice.application.service.UserService;
import com.example.memberservice.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final UserService userService;

    @PostMapping("/member/v1/users/registration")
    public UserResponse registerUser(@RequestBody UserRegisterRequest rq) {
        userService.registerUser(rq.loginId(), rq.userName());
        return new UserResponse(true, null);
    }

    @PutMapping("/member/v1/users/{userId}/modify")
    public UserResponse modifyUser(@PathVariable(value = "userId") Long userId, @RequestBody UserModifyRequest rq) {
        userService.modifyUser(userId, rq.userName());
        return new UserResponse(true, null);
    }

    @PostMapping("/member/v1/users/{loginId}/login")
    public Users login(@PathVariable(value = "loginId") String loginId) {
        return userService.getUser(loginId);
    }
}
