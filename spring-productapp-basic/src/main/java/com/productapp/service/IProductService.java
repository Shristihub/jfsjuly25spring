package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
	List<Product> getAll();
	List<Product> getByBrand(String brand) throws ProductNotFoundException;
	List<Product> getByLesserPrice(double price)throws ProductNotFoundException;
	List<Product> getByCategoryandNameContains(String category, String name)throws ProductNotFoundException;
	Product getById(int productId)throws ProductNotFoundException;
	
	

}
