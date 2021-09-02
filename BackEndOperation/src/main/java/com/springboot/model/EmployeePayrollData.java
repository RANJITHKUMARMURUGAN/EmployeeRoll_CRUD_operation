package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name="emplyoyees ")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation specifies the 
	private long id;                                //generation strategies for the values of primary key 
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
}
