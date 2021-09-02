package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.EmployeePayrollDTO;
import com.springboot.dto.ResponseDTO;
import com.springboot.exception.NotFoundException;
import com.springboot.model.EmployeePayrollData;
import com.springboot.services.IEmployeePayrollService;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> employeeList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO responseDTO = new ResponseDTO("Fetched all Employee Payroll Details", employeeList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO,
			BindingResult e) {
		EmployeePayrollDTO addData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Added Employee Payroll Details", addData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{empID}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int empID,
			@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) throws NotFoundException {
		EmployeePayrollDTO updatedData = employeePayrollService.updateEmployeePayrollData(empID, employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated by ID : Employee Payroll Details", updatedData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployeeDetails(@PathVariable(name = "id") int id) {
		employeePayrollService.deleteEmployeePayrollData(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : Employee Payroll Details", null);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
