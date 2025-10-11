package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name="product_details")  // to give a different table name
public class Product {

	@Column(length = 20)
	private String productName;
	@Id
	@GeneratedValue
	private Long productId;
	@Column(length = 20)
	private String brand;
	@Column(length = 20)
	private String category;
	@Column(name="cost")
	private double price;
	
	
}


//product
//product_seq




