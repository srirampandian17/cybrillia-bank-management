package com.cybrilla.bankmanagement.repository;

import com.cybrilla.bankmanagement.model.Payee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayeeRepository extends JpaRepository<Payee, Long> {
}
