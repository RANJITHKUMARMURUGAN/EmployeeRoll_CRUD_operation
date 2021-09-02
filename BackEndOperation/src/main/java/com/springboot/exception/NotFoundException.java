package com.springboot.exception;

public class NotFoundException extends EmployeePayrollException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
	}
}