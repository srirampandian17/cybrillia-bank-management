package com.cybrilla.bankmanagement.model;

import com.cybrilla.bankmanagement.constants.TransactionType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Basic
    private java.sql.Date transactionDate;

    private String transactionRemarks;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    private int amount;

}
