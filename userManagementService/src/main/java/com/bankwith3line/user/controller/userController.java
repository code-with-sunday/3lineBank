package com.bankwith3line.user.controller;

import com.bankwith3line.user.dto.request.UserRequest;
import com.bankwith3line.user.dto.response.ApiResponse;
import com.bankwith3line.user.dto.response.UserResponse;
import com.bankwith3line.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class userController {

    private final UserService userService;

    @PostMapping("/")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/all")
    public ApiResponse<List<UserResponse>> getAllUsers() {
        return userService.getAllUsers();
    }

}