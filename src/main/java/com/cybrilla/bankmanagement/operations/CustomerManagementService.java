package com.cybrilla.bankmanagement.operations;

import com.cybrilla.bankmanagement.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerManagementService {
    public Message addPayee(Payee payee) throws Exception;

    public Message removePayee(Payee payee) throws Exception;

    public Optional<Transaction> getAccountStatementList(Customer customer) throws Exception;

    public Message addCustomer(Customer customer) throws Exception;

    public Message addTransaction(Transaction transaction) throws Exception;

}
