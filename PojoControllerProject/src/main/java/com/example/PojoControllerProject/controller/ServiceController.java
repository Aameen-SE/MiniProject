package com.example.PojoControllerProject.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PojoControllerProject.beans.Manager;
import com.example.PojoControllerProject.beans.Student;
import com.example.PojoControllerProject.beans.User;
import com.example.PojoControllerProject.service.AllServices;


@RestController
@RequestMapping("/get")
public class ServiceController {

	private final AllServices allServices;
	
	public ServiceController(AllServices allServices) {
		this.allServices=allServices;
	}
	
	@GetMapping("/user")
	public User getUser() {
		return allServices.getUser();
	}
	
	@GetMapping("/student")
	public Student getStudent() {
		return allServices.getStudent();
	}
	
	 @GetMapping("/manager")
	public Manager getManager() {
		
		return allServices.getManager();
	}
	
	 @GetMapping("/userList")
	 public List<User> getUserList(){
		 return allServices.getUserList();
	 }
	
	 @GetMapping("/studentList")
	 public List<Student> getStudentList(){
		 return allServices.getStudentList();
	 }
	 
	 @GetMapping("/managerList")
	 public List<Manager> getManagerList(){
		 return allServices.getManagerList();
	 }
	
}
