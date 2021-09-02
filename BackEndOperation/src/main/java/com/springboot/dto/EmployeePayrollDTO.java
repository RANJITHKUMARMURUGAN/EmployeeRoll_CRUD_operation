package com.springboot.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}", message = "Employee name Invalid")
	private String name;
	private String gender;

	@Min(value = 1000, message = "Min salary should be more than 1000")
	private String salary;

	@Pattern(regexp = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$", message = "Employee email id is  Invalid")
	private String email;

	private List<String> department;

	private String profilePic;
	private LocalDateTime startDate;
	private String notes;
}
