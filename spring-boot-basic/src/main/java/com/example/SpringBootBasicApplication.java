package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.javabased.Student;
import com.spring.javabased1.*;
import com.spring.setter.Employee;

@SpringBootApplication(scanBasePackages = {"com.example","com.spring"})
public class SpringBootBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}
	
	@Autowired
	private ApplicationContext context;
//	
	private Employee employee;
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Autowired
	ShapeFactory factory;
	
	@Autowired
	Student student;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(employee);
//		System.out.println(employee.getAddress().getCity());
//		System.out.println();
		Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		factory.printArea("t", 10, 10);
		
//		System.out.println(student);
//		Student st = context.getBean("myStudent", Student.class);
//		System.out.println(st);
	}

}
