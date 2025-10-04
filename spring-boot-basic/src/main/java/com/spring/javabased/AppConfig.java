package com.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	//create bean definition
	// bean name  is the method name
	@Bean
	Student getStudent() {
		return new Student();
	}
}
