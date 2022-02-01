package com.cybrilla.bankmanagement.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String bankName;

    @OneToMany(mappedBy = "bank")
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "bank" )
    private List<Customer> customerList;
}
