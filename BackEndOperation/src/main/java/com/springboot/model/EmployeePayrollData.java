package com.springboot.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springboot.converter.ListToJSONConvertor;

import lombok.Data;

@Data
@Entity
@Table(name = "employeeService ")
public class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation specifies the
	// generation strategies for the values of primary key

	private int id;
	private String name;
	private String gender;
	private String salary;
	private String email;

	@Convert(converter = ListToJSONConvertor.class)
	private List<String> department;

	private String profilePic;
	private LocalDateTime startDate;
	private String notes;

}
