package com.sk.sample.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sk.sample.model.Employee;
import com.sk.sample.model.EmployeeData;
import com.sk.sample.service.ThirdPartyService;


@RestController
@RequestMapping(path = "/api")
public class ThirdPartyController {

	@Autowired
	ThirdPartyService thirdPartyService;
	
	
	// POST call to save data
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody Employee emp) {
		
		return thirdPartyService.saveEmployee(emp);
		
		
		
	}

	
	// POST call to get data
	  @PostMapping(path= "/fetchEmployee", consumes = "application/json", produces = "application/json")
	  public Optional<Employee> findEmployee(@RequestBody EmployeeData request) { 
	
	  
		  return thirdPartyService.getEmployee(request);
			  
	  }
	  
	
	 
 }
	

