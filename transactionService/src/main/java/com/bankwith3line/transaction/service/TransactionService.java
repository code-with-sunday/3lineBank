package com.bankwith3line.transaction.service;

import com.bankwith3line.common.dto.response.ApiResponse;
import com.bankwith3line.common.dto.response.TransactionResponse;

public interface TransactionService {
    ApiResponse<TransactionResponse> createTransaction(Long accountId, double amount);
    ApiResponse<TransactionResponse> getUserTransactions(Long userId);
}
