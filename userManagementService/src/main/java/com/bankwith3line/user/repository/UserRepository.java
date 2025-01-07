package com.bankwith3line.user.repository;

import com.bankwith3line.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    boolean existsByAccountNumber(String accountNumber);
}
