package com.spring.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Course {
	
	private String courseName;
	private String type;
	public String getCourseName() {
		return courseName;
	}
	@Value("Java")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getType() {
		return type;
	}
	@Value("Backend")
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", type=" + type + "]";
	}
	
	

}
