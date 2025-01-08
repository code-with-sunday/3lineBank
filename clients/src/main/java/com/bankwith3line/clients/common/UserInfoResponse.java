package com.bankwith3line.clients.common;

import com.bankwith3line.common.dto.request.TransactionSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private String firstName;
    private String surname;
    private BigDecimal balance;
    private List<TransactionSummary> transactions;
}