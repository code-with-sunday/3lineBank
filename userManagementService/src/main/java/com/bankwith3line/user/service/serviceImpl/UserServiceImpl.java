package com.bankwith3line.user.service.serviceImpl;

import com.bankwith3line.user.dto.request.UserRequest;
import com.bankwith3line.user.dto.response.ApiResponse;
import com.bankwith3line.user.dto.response.UserResponse;
import com.bankwith3line.user.entity.User;
import com.bankwith3line.user.exception.NotFoundException;
import com.bankwith3line.user.mapper.UserMapper;
import com.bankwith3line.user.repository.UserRepository;
import com.bankwith3line.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ApiResponse<UserResponse> createUser(UserRequest userRequest) {

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return new ApiResponse<>(false, "409", "Email is already in use", null);
        }

        User user = userMapper.toEntity(userRequest);
        user.prePersist();
        User savedUser = userRepository.save(user);
        UserResponse userResponse = userMapper.toResponse(savedUser);

        return new ApiResponse<>(true, "201", "User created successfully", userResponse);
    }

    @Override
    public ApiResponse<UserResponse> getUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.prePersist();
        UserResponse userResponse = userMapper.toResponse(user);

        return new ApiResponse<>(true, "200", "User retrieved successfully", userResponse);
    }

    @Override
    public ApiResponse<List<UserResponse>> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserResponse> userResponses = users.stream()
                .map(userMapper::toResponse)
                .toList();

        return new ApiResponse<>(true, "200", "All users retrieved successfully", userResponses);
    }

}
