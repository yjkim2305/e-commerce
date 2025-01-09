package com.example.memberservice.api;

import com.example.memberservice.api.request.UserRegisterRequest;
import com.example.memberservice.api.response.UserResponse;
import com.example.memberservice.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final UserService userService;

    @PostMapping("/member/v1/users/registration")
    public UserResponse registerUser(@RequestBody UserRegisterRequest rq) {
        userService.registerUser(rq.getLoginId(), rq.getUserName());
        return new UserResponse(true, null);
    }
}
