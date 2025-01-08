package com.bankwith3line.user.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;

    private String firstName;

    private String username;

    private String email;

    private String phoneNumber;

    private String address;

    private String role;

    private String createdAt;

    private String updatedAt;
}
