package com.sk.sample.model;

import java.util.List;

public class EmployeeDataRequest {
	
	private String requestId;
	private List<EmployeeData> empData;
	
	public EmployeeDataRequest() {
	}
	
	public EmployeeDataRequest(String requestId, List<EmployeeData> empData) {
		super();
		this.requestId = requestId;
		this.empData = empData;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<EmployeeData> getEmpData() {
		return empData;
	}

	public void setEmpData(List<EmployeeData> empData) {
		this.empData = empData;
	}
	
	

	@Override
	public String toString() {
		return "EmployeeDataRequest [requestId=" + requestId + ", empData=" + empData + "]";
	}
	
	
	
	
	
	
	
	

}
