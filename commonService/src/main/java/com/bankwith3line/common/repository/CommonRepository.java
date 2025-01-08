package com.bankwith3line.common.repository;

import com.bankwith3line.common.entity.Common;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommonRepository extends JpaRepository<Common, Long> {
    Optional<Common> findByEmail(String email);
}
