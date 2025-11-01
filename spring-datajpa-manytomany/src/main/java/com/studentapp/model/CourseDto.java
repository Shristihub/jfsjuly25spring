package com.studentapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "students")
public class CourseDto {
	private Integer courseId;
	private String courseName;
	private Mode mode;
	private String category; // take values from enum web,frontend
	private String duration;
	private CourseLevel courseLevel;
	private String instructor;
	private List<StudentDto> students;
	public CourseDto( String courseName, Mode mode, String category, String duration,
			CourseLevel courseLevel, String instructor) {
		super();
		this.courseName = courseName;
		this.mode = mode;
		this.category = category;
		this.duration = duration;
		this.courseLevel = courseLevel;
		this.instructor = instructor;
	}
	
	
	
	
	

}
