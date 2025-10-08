package com.example.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // has bean definition
public class AppConfig {
	
	@Bean
	// this is a vbean definition
	// the method name is the beanName
	Student myStudent() {
		Student student = new Student();
		student.setCourse(course());
		return student;
	}

	@Bean
	Course course() {
		return new Course();
	}
}
