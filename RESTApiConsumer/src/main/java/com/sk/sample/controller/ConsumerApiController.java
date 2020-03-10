package com.sk.sample.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.model.CollatedResponse;
import com.sk.sample.model.EmployeeDataRequest;
import com.sk.sample.service.ConsumerService;


@RestController
@RequestMapping(path = "/api")
public class ConsumerApiController {

	@Autowired
	ConsumerService thirdPartyService;
	
	
	
	// POST example
	  @PostMapping(path= "/empData", consumes = "application/json", produces = "application/json")
	  public CollatedResponse findEmployee(@RequestBody EmployeeDataRequest request) throws InterruptedException, ExecutionException { 
		  long start_time = System.nanoTime();
		  
		  CollatedResponse collatedResponse =  thirdPartyService.getEmployee(request);
		  
		  long end_time = System.nanoTime();
		  double difference = (end_time - start_time) / 1e6;
		
		  System.out.println("TOTAL TIME IN GETTING RESPONSE: " + difference + " Milliseconds");
			
		  return collatedResponse;
	  }
	 
 }
	

