package com.spring.javabased;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	private String studentName;
	private String department;
	
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
		return "Student [studentName=" + studentName + ", department=" + department + ", course=]";
	}

}
