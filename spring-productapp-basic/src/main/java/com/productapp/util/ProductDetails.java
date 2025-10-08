package com.productapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.productapp.model.Product;

@Component
public class ProductDetails {

	// read from a csv file thta has list of products
	// add it to an arraylist
	public List<Product> showProducts(){
		return Arrays.asList(
			new Product("Football",1,"Nike","Sports",220),
			new Product("Shoes",2,"Nike","Sports",4220),
			new Product("Tennisball",3,"Cosco","Sports",520),
			new Product("Notebook",4,"Classmate","Stationary",120),
			new Product("Basketball",5,"Cosco","Sports",1220)
				);
	}
}
