package com.cybrilla.bankmanagement.controller;

import com.cybrilla.bankmanagement.model.Employee;
import com.cybrilla.bankmanagement.model.Message;
import com.cybrilla.bankmanagement.operations.EmployeeManagementService;
import com.cybrilla.bankmanagement.operations.impl.EmployeeManagementServiceImpl;
import com.cybrilla.bankmanagement.repository.EmployeeRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest  {

    @InjectMocks
    private EmployeeManagementServiceImpl employeeManagementService;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void addEmployee()  throws Exception
    {
        Message message=new Message();
        Employee employee=new Employee();
        employee.setFirstName("test user");
        employee.setLastName("last user");
        employee.setEmailId("test@test.com");
        message.setMessage("Employee "+employee.getFirstName()+" saved successfully" );
        Mockito.when(restTemplate.postForEntity("http://localhost:8080/employee/addEmployee",employee,Employee.class))
                .thenReturn(new ResponseEntity(message, HttpStatus.OK));
        Message messageresp= employeeManagementService.addEmployee(employee);
        Assert.assertEquals(message, messageresp);
    }
}