package com.bankwith3line.common.dto.request;

import com.bankwith3line.common.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private Long accountId;
    private TransactionType type;
    private BigDecimal amount;
}