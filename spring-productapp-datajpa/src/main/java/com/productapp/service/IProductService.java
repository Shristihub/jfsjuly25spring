package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
	//crud operation
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	List<Product> getAll();
	Product getById(int productId)throws ProductNotFoundException;
	
	// querying
	
	List<Product> getByBrand(String brand) throws ProductNotFoundException;
	List<Product> getByLesserPrice(double price)throws ProductNotFoundException;
	List<Product> getByCategoryandNameContains(String category, String name)throws ProductNotFoundException;
	
	

}
