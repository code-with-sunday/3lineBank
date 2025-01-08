package com.bankWith3Line.account.service;

import com.bankwith3line.common.dto.response.ApiResponse;

import java.math.BigDecimal;

public interface AccountService {
    ApiResponse openCurrentAccount(Long customerId, double initialCredit);

    BigDecimal getUserBalance(Long customerId);
}
