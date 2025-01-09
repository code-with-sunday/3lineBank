package com.bankWith3Line.account.controller;

import com.bankWith3Line.account.service.AccountService;
import com.bankwith3line.common.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/open")
    public ApiResponse openCurrentAccount(
            @RequestParam Long customerId,
            @RequestParam double initialCredit) {
        return accountService.openCurrentAccount(customerId, initialCredit);
    }

    @GetMapping("/{customerId}/balance")
    public BigDecimal getUserBalance(@PathVariable Long customerId) {
        return accountService.getUserBalance(customerId);
    }
}
