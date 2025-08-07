package com.employeereport.EmployeeReport.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeereport.EmployeeReport.model.Employee;
import com.employeereport.EmployeeReport.repository.EmployeeRepository;
import com.employeereport.EmployeeReport.service.ReportService;

import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ReportService reportService;
	
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return reportService.exportReport(format);
	}
	
}
