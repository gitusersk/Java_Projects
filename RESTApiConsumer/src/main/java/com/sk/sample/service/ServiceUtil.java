package com.sk.sample.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.sk.sample.model.Employee;
import com.sk.sample.model.EmployeeData;

public class ServiceUtil {
	
	
	public Employee apiCallAsync(String apiUri, EmployeeData employeeData) {
		RestTemplate restTemplate = new RestTemplate();
		
		DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
		Date date1 = new Date();
		System.out.println("Thread Start time: " + Thread.currentThread().getName() + " => "+dateFormat1.format(date1));
		
		long start_time = System.nanoTime();
		
		Employee thirdPartyResp=restTemplate.postForObject(apiUri, employeeData, Employee.class);
		
		DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
		Date date2 = new Date();
		System.out.println("Thread End time: " +Thread.currentThread().getName() +" => "+ dateFormat2.format(date2));
		
		long end_time = System.nanoTime();
		double difference = (end_time - start_time) / 1e6;
		
		System.out.println("Total Time taken by Thread: "+Thread.currentThread().getName() + " => " +difference + " Milliseconds");
		
		return thirdPartyResp;
	}

}
