package com.example.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private String studName;
	private String department;
//	@Autowired   - inject the dependency in th econfig class
	private Course course;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getStudName() {
		return studName;
	}
	@Value("John")
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getDepartment() {
		return department;
	}
	@Value("CSE")
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [studName=" + studName + ", department=" + department + ", course=" + course + "]";
	}
	

}
