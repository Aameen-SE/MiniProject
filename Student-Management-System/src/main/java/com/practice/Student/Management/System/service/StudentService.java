package com.practice.Student.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Student.Management.System.entities.Student;
import com.practice.Student.Management.System.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	// add student 
	
	public Student addStuddent(Student student) {
		
		return repo.save(student);
	}
	
	//View all students
	
	public List<Student> viewStudent(){
		return repo.findAll();
	}
	
	//viewStudent by id 
	
	public Optional<Student> viewStudentById(Long id){
		
		return repo.findById(id);
	}
		
	
	// update Student
	
	public Student updateStudent(Long id, Student updateStudent) {
		
	/*	if(repo.findById(id)!=null) {
			
			Student student = new Student();
			student.setName(updateStudent.getName());
			student.setCourse(updateStudent.getCourse());
			student.setEmail(updateStudent.getEmail());
			
			return repo.save(student);
			
		}else
			return null;
	}*/
		Student student = repo.findById(id).orElseThrow();
		student.setName(updateStudent.getName());
		student.setCourse(updateStudent.getCourse());
		student.setEmail(updateStudent.getEmail());
		
		return repo.save(student);
}
	
	// delete student 
	
	public void deleteStudent(Long id) {
		
		 repo.deleteById(id);
	}
}
