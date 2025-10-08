package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	private String productName;
	private Long productId;
	private String brand;
	private String category;
	private double price;
	
	
}
