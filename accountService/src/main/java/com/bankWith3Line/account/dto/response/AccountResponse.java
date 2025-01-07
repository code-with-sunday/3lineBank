package com.bankWith3Line.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private Long id;

    private Long customerId;

    private String accountNumber;

    private BigDecimal balance;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}