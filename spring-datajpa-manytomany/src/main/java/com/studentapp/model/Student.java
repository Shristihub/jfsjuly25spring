package com.studentapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(generator = "student_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_gen",sequenceName = "student_seq",initialValue = 1,allocationSize = 1)
	private Integer studentId;
	@Column(length=30)
	private String studentName;
	@Column(length=30)
	private String department;
	@Column(length=30)
	private String city;
	@ManyToMany
	private List<Course> courses;
	
	
	

}
