package com.employeereport.EmployeeReport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeereport.EmployeeReport.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
