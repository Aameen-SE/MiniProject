package com.example.PojoControllerProject.beans;

public class Manager {
	
	private int empId;
	private String department;
	
	public Manager() {}
	
	public Manager(int empId, String department) {
		this.empId=empId;
		this.department=department;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
