package com.bankwith3line.user.mapper;

import com.bankwith3line.common.dto.request.UserRequest;
import com.bankwith3line.common.dto.response.UserResponse;
import com.bankwith3line.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }

        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setSurname(userRequest.getSurname());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setAddress(userRequest.getAddress());
        return user;
    }

    public UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .username(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .role(user.getRole().name())
                .createdAt(user.getCreatedAt() != null ? user.getCreatedAt().toString() : null)
                .updatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt().toString() : null)
                .build();
    }
}

