package com.bankwith3line.transaction.repository;

import com.bankwith3line.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByAccountId(Long accountId);
    List<Transaction> findAllByAccountId(Long accountId);
}
