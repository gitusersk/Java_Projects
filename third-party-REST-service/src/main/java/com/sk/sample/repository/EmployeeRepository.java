package com.sk.sample.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.sk.sample.model.Employee;



public interface EmployeeRepository extends MongoRepository<Employee, Integer>
{
	
}

