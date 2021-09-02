package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BackEndOperation1Application {

	public static void main(String[] args) {
		System.out.println("welcome to spring boot");
		SpringApplication.run(BackEndOperation1Application.class, args);
		// System.out.println("The Spring Boot is going Running Successfully..!");
		log.info("The Spring Boot is going Running Successfully..!");
	}
}
