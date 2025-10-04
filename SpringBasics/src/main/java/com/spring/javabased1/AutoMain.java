package com.spring.javabased1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		context.register(ShapeConfig.class);
		context.refresh();
		Rectangle rect1 = context.getBean("rectangle1",Rectangle.class);
		System.out.println(rect1.hashCode());
		Rectangle rect2 = context.getBean("rectangle2",Rectangle.class);
		System.out.println(rect2.hashCode());
		System.out.println(rect1==rect2);
		
		
		
	}
}
