package com.bankwith3line.clients.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient("accountService")
public interface AccountBalanceClient {
    @GetMapping("/api/v1/accounts/{customerId}/balance")
    BigDecimal getUserBalance(@PathVariable Long customerId);
}
