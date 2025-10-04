package com.spring.javabased1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShapeConfig {

	// create bean definition
	// bean name is the method name
	@Bean
	Square getSquare() {
		return new Square();
	}
	@Bean
	Rectangle rectangle1() {
		return new Rectangle();
	}
	
	@Bean
	Rectangle rectangle2() {
		return rectangle1();
	}
	@Bean
	Triangle getTriangle() {
		return new Triangle();
	}
	@Bean
	ShapeFactory getShapeFactory() {
		ShapeFactory factory =  new ShapeFactory();
		factory.setShape(rectangle1());
		return factory;
	}
}
