package com.bankwith3line.user.service;


import com.bankwith3line.common.dto.request.UserRequest;
import com.bankwith3line.common.dto.response.ApiResponse;
import com.bankwith3line.common.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    ApiResponse<UserResponse> createUser(UserRequest userRequest);
    ApiResponse<UserResponse> getUser(Long userId);
    ApiResponse<List<UserResponse>> getAllUsers();
}
