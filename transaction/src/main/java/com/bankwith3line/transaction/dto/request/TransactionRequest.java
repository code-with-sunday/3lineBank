package com.bankwith3line.transaction.dto.request;

import com.bankwith3line.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private UUID accountId;
    private TransactionType type;
    private BigDecimal amount;
}