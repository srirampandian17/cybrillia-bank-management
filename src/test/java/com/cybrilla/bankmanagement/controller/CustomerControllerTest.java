package com.cybrilla.bankmanagement.controller;

import com.cybrilla.bankmanagement.model.Bank;
import com.cybrilla.bankmanagement.model.Customer;
import com.cybrilla.bankmanagement.model.Message;
import com.cybrilla.bankmanagement.operations.impl.CustomerManagementServiceImpl;
import com.cybrilla.bankmanagement.repository.CustomerRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @InjectMocks
    private CustomerManagementServiceImpl customerManagementService;

    @Mock
    CustomerRepository customerRepository;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void addCustomer()  throws Exception
    {
        Message message=new Message();
        Customer customer=new Customer();
        customer.setName("test customer");
        Bank bank=new Bank();
        bank.setId(2L);
        customer.setBank(bank);
        message.setMessage(" Customer "+customer.getName()+" added successfully");
        Mockito.when(restTemplate.postForEntity("http://localhost:8080/customer/addCustomer",customer,Customer.class))
                .thenReturn(new ResponseEntity(message, HttpStatus.OK));
        Message messageresp= customerManagementService.addCustomer(customer);
        Assert.assertEquals(message, messageresp);
    }
}