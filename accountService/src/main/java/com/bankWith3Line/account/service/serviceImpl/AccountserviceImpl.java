package com.bankWith3Line.account.service.serviceImpl;

import com.bankWith3Line.account.dto.response.ApiResponse;
import com.bankWith3Line.account.entity.Account;
import com.bankWith3Line.account.enums.AccountStatus;
import com.bankWith3Line.account.repository.AccountRepository;
import com.bankWith3Line.account.service.AccountService;
import com.bankWith3Line.account.utils.AccountNumberGenerator;
import com.bankwith3line.transaction.service.TransactionService;
import com.bankwith3line.user.entity.User;
import com.bankwith3line.user.exception.NotFoundException;
import com.bankwith3line.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountserviceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountNumberGenerator accountNumberGenerator;
    private final TransactionService transactionService;

    @Override
    public ApiResponse openCurrentAccount(Long customerId, double initialCredit) {
        User user = userRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        String accountNumber = generateUniqueAccountNumber();

        Account account = new Account();
        account.setCustomerId(customerId);
        account.setAccountNumber(accountNumber);
        account.setBalance(BigDecimal.ZERO);
        account.setStatus(AccountStatus.ACTIVE);
        accountRepository.save(account);

        if (initialCredit > 0) {
            transactionService.createTransaction(account.getId(), initialCredit);
            account.setBalance(BigDecimal.valueOf(initialCredit));
            accountRepository.save(account);
        }

        String message = String.format("Account %s opened for %s with initial credit of %.2f",
                accountNumber, user.getFirstName(), initialCredit);

        return new ApiResponse<>(true, "201", message, null);
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        boolean exists;
        do {
            accountNumber = accountNumberGenerator.generateAccountNumber();
            exists = userRepository.existsByAccountNumber(accountNumber);
        } while (exists);

        return accountNumber;
    }
}
