package com.bankwith3line.common.service;

import com.bankwith3line.common.dto.response.UserInfoResponse;

public interface CommonService {
    UserInfoResponse getUserInfo(String email);
}
