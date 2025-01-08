package com.bankWith3Line.account.repository;

import com.bankWith3Line.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
    Optional<Account> findByCustomerId(Long userId);
    boolean existsByAccountNumber(String accountNumber);

}
