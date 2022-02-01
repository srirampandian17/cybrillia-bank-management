package com.cybrilla.bankmanagement.model;

import com.cybrilla.bankmanagement.constants.AccountDetailsType;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Data
@Entity
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int balance;

    private AccountDetailsType accountDetailsType;

}
