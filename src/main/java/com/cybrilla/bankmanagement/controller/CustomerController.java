package com.cybrilla.bankmanagement.controller;

import com.cybrilla.bankmanagement.model.*;
import com.cybrilla.bankmanagement.operations.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerManagementService customerManagementService;

    @PostMapping("/addCustomer")
    public Message addCustomer(@Valid @RequestBody Customer customer) throws Exception
    {
        return customerManagementService.addCustomer(customer);
    }

    @PostMapping("/addTransaction")
    public Message addCustomer(@Valid @RequestBody Transaction transaction) throws Exception
    {
        return customerManagementService.addTransaction(transaction);
    }

    @PostMapping("/addPayee")
    public Message addPayee(@Valid @RequestBody Payee payee) throws Exception
    {
        return customerManagementService.addPayee(payee);
    }

    @PostMapping("/removePayee")
    public Message removePayee(@Valid @RequestBody Payee payee) throws Exception
    {
        return customerManagementService.removePayee(payee);
    }

    @PostMapping("/getAccountStatementList")
    public Optional<Transaction> getAccountStatementList(@Valid @RequestBody Customer customer) throws Exception
    {
        return customerManagementService.getAccountStatementList(customer);
    }

}
