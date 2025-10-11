package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;

public interface IProductService {
	//crud operation
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(long productId); 
	List<ProductDto> getAll();
	ProductDto getById(long productId)throws ProductNotFoundException;
	
	// querying
	
	List<ProductDto> getByBrand(String brand) throws ProductNotFoundException;
	List<ProductDto> getByLesserPrice(double price)throws ProductNotFoundException;
	List<ProductDto> getByCategoryandNameContains(String category, String name)throws ProductNotFoundException;
	
	

}
