package com.bankwith3line.common.dto.response;

import com.bankwith3line.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private UUID transactionId;
    private Long accountId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}