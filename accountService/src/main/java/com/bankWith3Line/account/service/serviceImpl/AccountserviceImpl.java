package com.bankWith3Line.account.service.serviceImpl;

import com.bankWith3Line.account.entity.Account;
import com.bankWith3Line.account.repository.AccountRepository;
import com.bankWith3Line.account.service.AccountService;
import com.bankWith3Line.account.utils.AccountNumberGenerator;
import com.bankwith3line.clients.transaction.TransactionClient;
import com.bankwith3line.clients.user.GetUserClient;
import com.bankwith3line.common.dto.response.ApiResponse;
import com.bankwith3line.common.dto.response.TransactionResponse;
import com.bankwith3line.common.dto.response.UserResponse;
import com.bankwith3line.common.enums.AccountStatus;
import com.bankwith3line.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountserviceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountNumberGenerator accountNumberGenerator;
    private final TransactionClient transactionClient;
    private final GetUserClient getUserClient;

    @Override
    public com.bankwith3line.common.dto.response.ApiResponse openCurrentAccount(Long customerId, double initialCredit) {
        UserResponse userResponse = getUserClient.getUser(customerId).getData();
        if (!userResponse.getId().equals(customerId)){
            throw new RuntimeException("User not found");
        }
        String accountNumber = generateUniqueAccountNumber();

        Account account = new Account();
        account.setCustomerId(customerId);
        account.setAccountNumber(accountNumber);
        account.setBalance(BigDecimal.ZERO);
        account.setStatus(AccountStatus.ACTIVE);
        account.prePersist();
        accountRepository.save(account);

        if (initialCredit > 0) {
            ApiResponse<TransactionResponse> transaction = transactionClient.createTransaction(account.getId(), initialCredit);
            if(Objects.isNull(transaction.getData().getTransactionId())){
                throw new RuntimeException("Transaction not found");
            }
            account.setBalance(BigDecimal.valueOf(initialCredit));
            accountRepository.save(account);

        }

        String message = String.format("Account %s opened for %s with initial credit of %.2f",
                accountNumber, userResponse.getFirstName(), initialCredit);

        return new ApiResponse<>(true, "201", message, null);

    }

    @Override
    public BigDecimal getUserBalance(Long customerId) {
        Account account = accountRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new NotFoundException("Account not found for customer"));

        BigDecimal accountBalance = account.getBalance();

        return accountBalance;
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        boolean exists;
        do {
            accountNumber = accountNumberGenerator.generateAccountNumber();
            exists = accountRepository.existsByAccountNumber(accountNumber);
        } while (exists);

        return accountNumber;
    }
}
