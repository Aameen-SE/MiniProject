package com.example.PojoControllerProject.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


import com.example.PojoControllerProject.beans.Manager;
import com.example.PojoControllerProject.beans.Student;
import com.example.PojoControllerProject.beans.User;

@Service
public class AllServices {
	
	
	public User getUser() {
		return new User("Aameen",145);
		}
	
	
	public Student getStudent() {
		return new Student(14,"Khan");
	}
	
	public Manager getManager() {
		return new Manager(145,"IT Department");
	}
	 
	 public List<User> getUserList(){
		 return Arrays.asList(new User("Ali",145), new User("Rahul",156));
	 }
	 
	 public List<Student> getStudentList(){
		 return Arrays.asList(new Student(156,"Faisal"), new Student(111,"Hussain"), new Student(133,"Arsalan"));
	 }
	 
	 public List<Manager> getManagerList(){
		 return Arrays.asList(new Manager(122,"Mechanical Department"),new Manager(551,"Electrical Department "),
				 new Manager(177,"Fire department"));
	 }
	
}
