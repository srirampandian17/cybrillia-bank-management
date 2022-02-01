package com.cybrilla.bankmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactionList;

    @OneToMany(mappedBy = "customer")
    private List<Payee> payeeList;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;

}
