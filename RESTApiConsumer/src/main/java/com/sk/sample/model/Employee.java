package com.sk.sample.model;


public class Employee {
	
	private int id;
	private String empName;
	private String empCompany;
	private String empCity;
	private String jobLevel;
	
	
	
	public Employee() {
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getEmpCompany() {
		return empCompany;
	}



	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}



	public String getEmpCity() {
		return empCity;
	}



	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}



	public String getJobLevel() {
		return jobLevel;
	}



	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empCompany=" + empCompany + ", empCity=" + empCity
				+ ", jobLevel=" + jobLevel + "]";
	}

	
	
	

}
