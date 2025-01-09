package com.bankwith3line.transaction.service.serviceImpl;

import com.bankwith3line.common.dto.response.ApiResponse;
import com.bankwith3line.common.dto.response.TransactionResponse;
import com.bankwith3line.common.enums.TransactionType;
import com.bankwith3line.transaction.entity.Transaction;
import com.bankwith3line.transaction.mapper.TransactionMapper;
import com.bankwith3line.transaction.repository.TransactionRepository;
import com.bankwith3line.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public ApiResponse<TransactionResponse> createTransaction(Long accountId, double amount) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setAmount(BigDecimal.valueOf(amount));
        transaction.setType(TransactionType.CREDIT);
        transaction.prePersist();
        Transaction savedTransaction = transactionRepository.save(transaction);
        TransactionResponse response = transactionMapper.toResponse(savedTransaction);
        return new ApiResponse<>(true, "201", "Transaction Successful", response );
    }

    @Override
    public ApiResponse<TransactionResponse> getUserTransactions(Long userId) {

        return null;
    }
}
