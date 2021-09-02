package com.springboot.services;

import java.util.List;

import com.springboot.dto.EmployeePayrollDTO;
import com.springboot.model.EmployeePayrollData;

import javassist.NotFoundException;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollDTO updateEmployeePayrollData(int empID, EmployeePayrollDTO empPayrollDTO) throws NotFoundException;

	void deleteEmployeePayrollData(int empId);
}
