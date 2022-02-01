package com.cybrilla.bankmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.cybrilla.bankmanagement.exception.ResourceNotFoundException;
import com.cybrilla.bankmanagement.model.Bank;
import com.cybrilla.bankmanagement.model.Employee;
import com.cybrilla.bankmanagement.model.Message;
import com.cybrilla.bankmanagement.operations.EmployeeManagementService;
import com.cybrilla.bankmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@PostMapping("/addEmployee")
	public Message addEmployee(@Valid @RequestBody Employee employee) throws Exception
	{
		return employeeManagementService.addEmployee(employee);
	}
}
