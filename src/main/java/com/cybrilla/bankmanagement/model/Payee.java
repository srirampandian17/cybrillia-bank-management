package com.cybrilla.bankmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Payee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
