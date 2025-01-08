package com.bankwith3line.common.service.ServiceImpl;

import com.bankWith3Line.account.entity.Account;
import com.bankWith3Line.account.repository.AccountRepository;
import com.bankwith3line.common.dto.request.TransactionSummary;
import com.bankwith3line.common.dto.response.UserInfoResponse;
import com.bankwith3line.common.entity.Common;
import com.bankwith3line.common.exception.NotFoundException;
import com.bankwith3line.common.repository.CommonRepository;
import com.bankwith3line.common.service.CommonService;
import com.bankwith3line.transaction.entity.Transaction;
import com.bankwith3line.transaction.repository.TransactionRepository;
import com.bankwith3line.user.entity.User;
import com.bankwith3line.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override
    public UserInfoResponse getUserInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Account userAccount = accountRepository.findByCustomerId(user.getId())
                .orElseThrow(() -> new NotFoundException("Account not found for customer"));

        List<Transaction> transactions = transactionRepository.findAllByAccountId(userAccount.getId());

        List<TransactionSummary> transactionSummaries = transactions.stream()
                .map(transaction -> new TransactionSummary(
                        transaction.getTransactionId(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getTimestamp()))
                .toList();

        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setFirstName(user.getFirstName());
        userInfoResponse.setSurname(user.getSurname());
        userInfoResponse.setBalance(userAccount.getBalance());
        userInfoResponse.setTransactions(transactionSummaries);

        return userInfoResponse;
    }
}
