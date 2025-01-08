package com.bankwith3line.common.entity;

import com.bankwith3line.common.dto.request.TransactionSummary;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "common")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Common extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private BigDecimal balance;

    @ElementCollection
    @CollectionTable(name = "common_transactions", joinColumns = @JoinColumn(name = "common_id"))
    private List<TransactionSummary> transactions = new ArrayList<>();
}