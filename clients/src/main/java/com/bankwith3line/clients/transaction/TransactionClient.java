package com.bankwith3line.clients.transaction;

import com.bankwith3line.common.dto.response.ApiResponse;
import com.bankwith3line.common.dto.response.TransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("transactionClient")
public interface TransactionClient {
    @PostMapping("/api/v1/transaction/create")
    ApiResponse<TransactionResponse> createTransaction(
            @RequestParam Long accountId,
            @RequestParam double amount);
}
