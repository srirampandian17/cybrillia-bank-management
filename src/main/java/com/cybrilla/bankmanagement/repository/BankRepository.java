package com.cybrilla.bankmanagement.repository;

import com.cybrilla.bankmanagement.model.Bank;
import com.cybrilla.bankmanagement.model.Customer;
import com.cybrilla.bankmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
