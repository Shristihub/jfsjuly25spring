package com.spring.javabased1;

import org.springframework.beans.factory.annotation.Autowired;

public class ShapeFactory {

//	@Autowired
	private IShape shape; // shape = new Rectangle();


	public void setShape(IShape shape) {
		this.shape = shape;
	}


	public void printArea(String choice, int x, int y) {
		System.out.println("Printing Area");
			shape.area(x, y);
		
	}
}
