package com.bankwith3line.common.controller;

import com.bankwith3line.common.dto.response.UserInfoResponse;
import com.bankwith3line.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/common")
public class CommonController {
    private final CommonService commonService;

    @GetMapping("/users/{email}")
    public UserInfoResponse getUserInfo(@PathVariable String email){
        return commonService.getUserInfo(email);
    }

}
