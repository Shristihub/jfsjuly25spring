package com.employeeapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {

	@Column(length = 20)
	private String empName;
	@Id
	@GeneratedValue
	private Integer empId;
	@Column(length = 20)
	private String department;
	private double salary;
	//added as a foreign key
	@OneToOne(cascade = CascadeType.PERSIST)
	//to change the column name
	@JoinColumn(name = "address_id")
	private Address address;


}




