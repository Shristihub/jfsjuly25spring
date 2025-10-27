package com.studentapp.model;

import java.util.List;


public record StudentDto(Integer studentId,
	String studentName,String department,
	String city,List<Course> courses) {
	
	

}
