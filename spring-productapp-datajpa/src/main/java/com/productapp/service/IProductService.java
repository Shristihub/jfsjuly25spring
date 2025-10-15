package com.productapp.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.ProductDto;

public interface IProductService {
	//crud operation
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(long productId); 
	List<ProductDto> getAll();
	ProductDto getById(long productId)throws ProductNotFoundException;
	
	// querying
	//derived
	List<ProductDto> getByBrand(String brand) throws ProductNotFoundException;
	List<ProductDto> getByLesserPrice(double price)throws ProductNotFoundException;
	List<ProductDto> getByCategoryandNameContains(String category, String name)throws ProductNotFoundException;
	
	//custom queries
	List<ProductDto> getByCategory(String category) throws ProductNotFoundException;
	List<ProductDto> getByBrandAndLessPrice(String brand,double price) throws ProductNotFoundException;
	List<ProductDto> getByNameContains(String name )throws ProductNotFoundException;

	//native query
	List<ProductDto> getByGreaterPrice(double price);
	
	//named query
	List<ProductDto> getByBrandAndCat(String brand,String cat);
	
	//using @Modifying
	void updateProduct(long productId,double price);
	
	//sorting
	List<ProductDto> getSortedProducts(String propertyName);
	List<ProductDto> getByBrand(String propertyName, String brand) throws ProductNotFoundException;
	
	//pagination
	List<ProductDto> getPagedProducts(int pageNo, int pageSize);
	
	
}






