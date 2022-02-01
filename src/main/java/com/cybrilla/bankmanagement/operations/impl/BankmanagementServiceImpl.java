package com.cybrilla.bankmanagement.operations.impl;

import com.cybrilla.bankmanagement.model.Bank;
import com.cybrilla.bankmanagement.model.Customer;
import com.cybrilla.bankmanagement.model.Employee;
import com.cybrilla.bankmanagement.model.Message;
import com.cybrilla.bankmanagement.operations.BankmanagementService;
import com.cybrilla.bankmanagement.repository.BankRepository;
import com.cybrilla.bankmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankmanagementServiceImpl implements BankmanagementService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Message createBank(Bank bank) throws Exception {
        bankRepository.save(bank);
        Message message=new Message();
        message.setMessage("New Bank added successfully");
        return message;
    }
}
