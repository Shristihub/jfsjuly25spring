package com.spring.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
	
	private String studentName;
	private String department;
	private Course course;
	
	public Student(Course course) {
		super();
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}
	@Value("CSE")
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStudentName() {
		return studentName;
	}
	@Value("Sri")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", department=" + department + ", course=" + course + "]";
	}

	
	
}
