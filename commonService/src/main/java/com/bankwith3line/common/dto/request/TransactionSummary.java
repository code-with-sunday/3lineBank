package com.bankwith3line.common.dto.request;

import com.bankwith3line.transaction.enums.TransactionType;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionSummary {
    private UUID transactionId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
