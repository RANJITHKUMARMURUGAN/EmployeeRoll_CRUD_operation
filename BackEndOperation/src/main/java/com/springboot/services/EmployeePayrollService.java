package com.springboot.services;

import com.springboot.dto.EmployeePayrollDTO;
import com.springboot.dto.ResponseDTO;
import com.springboot.exception.EmployeePayrollException;
import com.springboot.model.EmployeePayrollData;
import com.springboot.repository.EmployeePayrollRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public interface EmployeePayrollService implements IEmployeePayrollService{
	@Autowired
    private EmployeePayrollRepository employeePayrollRepository;
	 @Autowired
	    private ModelMapper modelMapper;
	 
	 @Override
	    public List<EmployeePayrollData> getEmployeePayrollData() {
	        return employeePayrollRepository.findAll().stream()
	                .map(contact -> modelMapper.map(contact, EmployeePayrollData.class))
	                .collect(Collectors.toList());
	    }
	 @Override
	    public EmployeePayrollDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
	        EmployeePayrollData employeeRequest = modelMapper.map(empPayrollDTO, EmployeePayrollData.class);
	        employeePayrollRepository.save(employeeRequest);
	        return empPayrollDTO;
	    }
	 @Override
	    public EmployeePayrollDTO updateEmployeePayrollData(int empID,
	                                                        EmployeePayrollDTO empPayrollDTO) {
	        EmployeePayrollDTO employeeResponse = null;
	        if (empID > 0) {
	            EmployeePayrollData empData = findEmployeeById(empID);
	            String[] ignoreFields = {"id", "startDate"};
	            BeanUtils.copyProperties(empPayrollDTO, empData, ignoreFields);
	            employeePayrollRepository.save(empData);
	            employeeResponse = modelMapper.map(empData, EmployeePayrollDTO.class);
	        }
	        return employeeResponse;
	    }
	 @Override
	    public void deleteEmployeePayrollData(int empId) {
	        EmployeePayrollData employeePayrollData = findEmployeeById(empId);
	        employeePayrollRepository.deleteById(empId);
	    }
	 private EmployeePayrollData findEmployeeById(int id) {
	        return employeePayrollRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException("Unable to find any Employee Payroll detail!"));
	    }
}
