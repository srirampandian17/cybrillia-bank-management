package com.cybrilla.bankmanagement.operations.impl;

import com.cybrilla.bankmanagement.model.Customer;
import com.cybrilla.bankmanagement.model.Employee;
import com.cybrilla.bankmanagement.model.Message;
import com.cybrilla.bankmanagement.operations.EmployeeManagementService;
import com.cybrilla.bankmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Message addEmployee(Employee employee) throws Exception {
        Message message=new Message();
        employeeRepository.save(employee);
        message.setMessage("Employee "+employee.getFirstName()+" saved successfully" );
        return message;
    }
}
