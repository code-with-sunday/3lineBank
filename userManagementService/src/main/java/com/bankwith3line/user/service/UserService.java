package com.bankwith3line.user.service;

import com.bankwith3line.common.dto.response.ApiResponse;
import com.bankwith3line.common.dto.response.UserResponse;
import com.bankwith3line.user.dto.request.UserRequest;

import java.util.List;

public interface UserService {
    ApiResponse<UserResponse> createUser(UserRequest userRequest);
    ApiResponse<UserResponse> getUser(Long userId);
    ApiResponse<List<UserResponse>> getAllUsers();
}
