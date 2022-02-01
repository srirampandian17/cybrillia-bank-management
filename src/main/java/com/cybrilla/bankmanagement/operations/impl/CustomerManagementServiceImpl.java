package com.cybrilla.bankmanagement.operations.impl;

import com.cybrilla.bankmanagement.model.*;
import com.cybrilla.bankmanagement.operations.CustomerManagementService;
import com.cybrilla.bankmanagement.repository.CustomerRepository;
import com.cybrilla.bankmanagement.repository.PayeeRepository;
import com.cybrilla.bankmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.cybrilla.bankmanagement.constants.TransactionType;

@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PayeeRepository payeeRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public Message addPayee(Payee payee) throws Exception
    {
        Message message=new Message();
        payee=payeeRepository.save(payee);
        message.setMessage(" Payee "+payee.getName()+" Id:"+ payee.getId()+" added successfully");
        return message;
    }

    @Override
    public Message removePayee(Payee payee) throws Exception {
        Message message=new Message();
        payeeRepository.delete(payee);
        message.setMessage(" Payee "+payee.getName()+" Id:"+ payee.getId()+" removed successfully");
        return message;
    }

    @Override
    public Optional<Transaction> getAccountStatementList(Customer customer) throws Exception{
        return transactionRepository.findById(customer.getId());
    }

    @Override
    public Message addCustomer(Customer customer) throws Exception {
        Message message=new Message();
        message.setMessage(" Customer "+customer.getName()+" added successfully");
        customerRepository.save(customer);
        return message;
    }

    @Override
    public Message addTransaction(Transaction transaction) throws Exception
    {
        Message message=new Message();
        updateAccountDetails(transaction);
        transactionRepository.save(transaction);
        message.setMessage(" Transaction added  Successfully");
        return message;
    }
    private void updateAccountDetails(Transaction transaction) throws Exception
    {
        Customer customer=transaction.getCustomer();
        AccountDetails accountDetails= customer.getAccountDetails();
        switch (transaction.getTransactionType())
        {
            case CREDIT:
                 accountDetails.setBalance(accountDetails.getBalance()+transaction.getAmount());
                 break;
            case DEBIT:
                accountDetails.setBalance(accountDetails.getBalance()-transaction.getAmount());
                break;
        }
    }


}
