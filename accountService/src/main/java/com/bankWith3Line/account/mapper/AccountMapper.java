package com.bankWith3Line.account.mapper;

import com.bankWith3Line.account.entity.Account;
import com.bankwith3line.common.dto.request.AccountRequest;
import com.bankwith3line.common.dto.response.AccountResponse;
import com.bankwith3line.common.enums.AccountStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountMapper {

    public Account toEntity(AccountRequest request) {
        Account account = new Account();
        account.setCustomerId(request.getCustomerId());
        account.setAccountNumber(request.getAccountNumber());
        account.setBalance(request.getBalance() != null ? request.getBalance() : BigDecimal.ZERO);
        account.setStatus(AccountStatus.valueOf(request.getStatus().toUpperCase()));
        return account;
    }

    public AccountResponse toResponse(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getCustomerId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getStatus().name(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }
}
