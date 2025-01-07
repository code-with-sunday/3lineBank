package com.bankwith3line.transaction.controller;

import com.bankwith3line.transaction.dto.response.ApiResponse;
import com.bankwith3line.transaction.dto.response.TransactionResponse;
import com.bankwith3line.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ApiResponse<TransactionResponse> createTransaction(
            @RequestParam Long accountId,
            @RequestParam double amount) {
        return transactionService.createTransaction(accountId, amount);
    }
}
