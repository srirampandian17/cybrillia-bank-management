package com.cybrilla.bankmanagement.controller;

import com.cybrilla.bankmanagement.model.Bank;
import com.cybrilla.bankmanagement.model.Employee;
import com.cybrilla.bankmanagement.model.Message;
import com.cybrilla.bankmanagement.operations.BankmanagementService;
import com.cybrilla.bankmanagement.operations.EmployeeManagementService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankmanagementService bankmanagementService;

    @PostMapping("/createBank")
    public Message createBank(@Valid @RequestBody Bank bank) throws Exception
    {
        return bankmanagementService.createBank(bank);
    }

}
