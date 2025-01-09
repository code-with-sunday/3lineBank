package com.bankwith3line.common.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String firstName;

    private String surname;

    private String email;

}
