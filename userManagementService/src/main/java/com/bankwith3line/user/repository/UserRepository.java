package com.bankwith3line.user.repository;

import com.bankwith3line.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
