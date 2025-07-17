package com.example.PojoControllerProject.beans;

public class Student {

	private int rollNo;
	private String name;
	
	public Student() {}
	
	public Student(int rollNo, String name) {
		this.rollNo=rollNo;
		this.name=name;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo=rollNo;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setSubject(String name) {
		this.name=name;
	}
	
	public String getname() {
		return name;
	}
	
}
