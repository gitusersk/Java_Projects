package com.sk.sample.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sk.sample.model.Employee;
import com.sk.sample.model.EmployeeData;
import com.sk.sample.repository.EmployeeRepository;

@Service
public class ThirdPartyService {

		
	@Autowired
	public EmployeeRepository employeeRepository;

	// save employee
	public String saveEmployee(Employee emp) {
		System.out.println("emp to save: "+emp);
			
		employeeRepository.save(emp);
		
		return "Added Employee with id : " + emp.getId();
	}
	
	
	// get employee
	public Optional<Employee> getEmployee(EmployeeData request) {
		System.out.println("request received: "+request);
			
		Optional<Employee> emp = employeeRepository.findById(request.getId());
		
		System.out.println("Employee Returned from Third Party Service: " + emp);
		
		return emp;
	}

		
	
}
