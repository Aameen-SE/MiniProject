package com.practice.Student.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.Student.Management.System.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
