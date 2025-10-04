package com.spring.javabased1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.javabased.Student;

@Configuration
public class ShapeConfig {

	// create bean definition
	// bean name is the method name
	@Bean
	Square getSquare() {
		return new Square();
	}
	@Bean
	Rectangle getRectangle() {
		return new Rectangle();
	}
	@Bean
	Triangle getTriangle() {
		return new Triangle();
	}
	@Bean
	ShapeFactory getShapeFactory() {
		return new ShapeFactory();
	}
}
