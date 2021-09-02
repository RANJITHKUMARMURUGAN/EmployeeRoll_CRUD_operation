package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Employee;

//Spring Data JPA internally provides @Repository Annotation so we no need to add @Repository annotation to EmployeeRepository interface

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
