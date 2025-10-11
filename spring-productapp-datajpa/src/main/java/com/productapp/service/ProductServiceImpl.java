package com.productapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
	
	private final IProductRepository productRepository;
	

	@Autowired
	private ModelMapper mapper;

	@Override
	public void addProduct(ProductDto productDto) {
		// convert productdto object to product object
		Product product = mapper.map(productDto, Product.class);
		// call the method of repository
		// check if id is available
		// if not autogenerate the id and save the object as a row
		// if available, check whether there is an existing row
		     // if yes, update, if no create a new record
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		// convert productdto object to product entity object
		Product product = mapper.map(productDto, Product.class);
		// call the method of repository
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(long productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDto> getAll() {
//		List<ProductDto> productDtos =  new ArrayList<>();
//		List<Product> products = productRepository.findAll();
//		 for (Product product : products) {
//			//convert entity to dto object
//			 ProductDto productDto =  mapper.map(product, ProductDto.class);
//			 productDtos.add(productDto);
//		}
//		return productDtos;
		
		//convert list into a stream
		List<ProductDto> productDtos = productRepository.findAll().stream()
					//convert one by one entity to dto object
					.map(product->mapper.map(product, ProductDto.class))
					.toList();
		return productDtos;
	}

	@Override
	public ProductDto getById(long productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(()-> new ProductNotFoundException("invalid id"));
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getByBrand(String brand) throws ProductNotFoundException {
		List<ProductDto> productDtos = productRepository.findBybrand(brand).stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this brand not found");
	return productDtos;
	}

	@Override
	public List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException {
		List<ProductDto> productDtos = productRepository.findByPriceLessThan(price).stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this brand not found");
	return productDtos;
	}

	@Override
	public List<ProductDto> getByCategoryandNameContains(String category, String name) throws ProductNotFoundException {
		List<ProductDto> productDtos = productRepository.findByCategoryAndProductNameContains(category, name)
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this brand not found");
	return productDtos;
	}

}
