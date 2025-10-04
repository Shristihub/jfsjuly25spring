package com.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {

	@Autowired
	@Qualifier("rectangle") // by type
	private IShape shape; // shape = new Rectangle();
	
	@Autowired
//	// by name - the instance variable name and the bean name should be same
	private IShape square; // shape = new Square();

	private IShape tshape;
	
//	//autowiring by constr - no need of @Autowired annotation
	public ShapeFactory(@Qualifier("triangle") IShape tshape) {
		super();
		this.tshape = tshape;
	}


	public void printArea(String choice, int x, int y) {
		System.out.println("Printing Area");
		if (choice.equals("r")) {
			shape.area(x, y);
		} else if (choice.equals("s")) {
			square.area(x, y);
		} else if (choice.equals("t")) {
			tshape.area(x, y);
		} else {
			System.out.println("wrong choice");
		}
		
	}
}
