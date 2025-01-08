package com.bankwith3line.clients.common;

import com.bankwith3line.common.dto.response.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("commonService")
public interface UserInfoClient {
    @GetMapping("api/v1/common/users/{email}")
    UserInfoResponse getUserInfo(@PathVariable String email);
}
