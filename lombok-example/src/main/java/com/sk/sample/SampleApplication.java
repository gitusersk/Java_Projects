package com.sk.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sk.sample.model.Employee;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
		
		
		Employee emp = new Employee();
		
		emp.setId(10011);
		emp.setEmpName("Ayushman Chauhan");
		emp.setEmpCompany("Alphabet Inc.");
		emp.setEmpCity("Hyderabad");
		emp.setJobLevel("5");
		
		
		System.out.println("emp: "+emp);
		
		System.out.println("******** Getter Examples Generated by Lombok ********");
		
		System.out.println("EmpCity: "+emp.getEmpCity());
		System.out.println("EmpCompany: "+emp.getEmpCompany());
		System.out.println("EmpName: "+emp.getEmpName());
		System.out.println("EmpId: "+emp.getId());
		System.out.println("JobLevel: "+emp.getJobLevel());
		
		
		
		
		
	}

}
