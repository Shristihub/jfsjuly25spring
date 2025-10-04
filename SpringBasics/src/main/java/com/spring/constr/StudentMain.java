package com.spring.constr;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		//create the IoC Container
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.spring");
		
//		Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		Student student1 =(Student) context.getBean("student");
		System.out.println("st1 "+student1.getStudentName());
		
		Student student2 =(Student) context.getBean("student");
		System.out.println("st2 "+student2.getStudentName());
		
		student1.setStudentName("Sripriya");
		System.out.println("st1 "+student1.getStudentName());
		System.out.println("st2 "+student2.getStudentName());
		
	}
}
