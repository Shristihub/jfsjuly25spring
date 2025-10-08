package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.util.ProductDetails;

@Service
public class ProductServiceImpl implements IProductService{
	
	private ProductDetails productDetails;
	//constr based DI
	public ProductServiceImpl(ProductDetails productDetails) {
		super();
		this.productDetails = productDetails;
	}

	@Override
	public List<Product> getAll() {
		return productDetails.showProducts();
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		return null;
	}

	@Override
	public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategoryandNameContains(String category, String name) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
	 // use optional and orelesthrow
		return null;
	}

}
