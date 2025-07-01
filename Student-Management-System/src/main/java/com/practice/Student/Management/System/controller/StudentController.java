package com.practice.Student.Management.System.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Student.Management.System.entities.Student;
import com.practice.Student.Management.System.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService stdService;

	@PostMapping("/addstudent")
	public Student addStuddent(@RequestBody Student student) {

		return stdService.addStuddent(student);
	}

	@GetMapping("/viewstudent")
	public ResponseEntity<List<Student>> viewStudent() {
		return ResponseEntity.ok(stdService.viewStudent());
	}
	
	@GetMapping("/viewstudent/{id}")
	public ResponseEntity<Optional<Student>> viewStudentById(@PathVariable Long id) {

	//	return ResponseEntity.ok( stdService.viewStudentById(id));
		
		Optional<Student> student = stdService.viewStudentById(id);
		
		if(student!=null) {
			return ResponseEntity.ok(student);
		}
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		
		return ResponseEntity.ok(stdService.updateStudent(id, student));
		
		
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public void deleteStudent(@PathVariable Long id) {
		stdService.deleteStudent(id);
	}
}
