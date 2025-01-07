package com.bankWith3Line.account.service;

import com.bankWith3Line.account.dto.response.ApiResponse;

public interface AccountService {
    ApiResponse openCurrentAccount(Long customerId, double initialCredit);

}
