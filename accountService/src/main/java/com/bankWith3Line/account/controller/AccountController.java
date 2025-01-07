package com.bankWith3Line.account.controller;

import com.bankWith3Line.account.dto.response.ApiResponse;
import com.bankWith3Line.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/open")
    public ApiResponse openCurrentAccount(
            @RequestParam Long customerId,
            @RequestParam double initialCredit) {
        return accountService.openCurrentAccount(customerId, initialCredit);
    }
}
