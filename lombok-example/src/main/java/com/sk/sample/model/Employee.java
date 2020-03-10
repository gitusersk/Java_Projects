package com.sk.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Employee {
	
	private int id;
	private String empName;
	private String empCompany;
	private String empCity;
	private String jobLevel;
	
}
