package com.bankwith3line.transaction.mapper;

import com.bankwith3line.common.dto.response.TransactionResponse;
import com.bankwith3line.transaction.dto.request.TransactionRequest;
import com.bankwith3line.transaction.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequest request) {
        if (request == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setAccountId(request.getAccountId());
        transaction.setType(request.getType());
        transaction.setAmount(request.getAmount());
        return transaction;
    }

    public TransactionResponse toResponse(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        return new TransactionResponse(
                transaction.getTransactionId(),
                transaction.getAccountId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getTimestamp()
        );
    }
}