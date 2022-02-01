package com.cybrilla.bankmanagement.operations;

import com.cybrilla.bankmanagement.model.Bank;
import com.cybrilla.bankmanagement.model.Customer;
import com.cybrilla.bankmanagement.model.Employee;
import com.cybrilla.bankmanagement.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankmanagementService {

    public Message createBank(Bank bank) throws Exception;

}
