package com.bankwith3line.clients.user;

import com.bankwith3line.common.dto.response.ApiResponse;
import com.bankwith3line.common.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("getUser")
public interface GetUserClient {
    @GetMapping(path = "/api/v1/user/{id}")
    ApiResponse<UserResponse> getUser(@PathVariable("id") Long id);
}
