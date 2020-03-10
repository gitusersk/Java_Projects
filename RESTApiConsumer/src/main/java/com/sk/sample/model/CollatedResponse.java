package com.sk.sample.model;

import java.util.List;

public class CollatedResponse {

	private String requestId;
	private List<Employee> empList;
	
	public CollatedResponse() {
		
	}
	
	public CollatedResponse(String requestId, List<Employee> empList) {
		super();
		this.requestId = requestId;
		this.empList = empList;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	
	@Override
	public String toString() {
		return "CollatedResponse [requestId=" + requestId + ", empList=" + empList + "]";
	}
	
	
	
	
}
