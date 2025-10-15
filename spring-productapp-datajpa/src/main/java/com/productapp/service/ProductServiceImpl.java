package com.productapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
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
//		List<ProductDto> productDtos = productRepository.findByCategoryAndProductNameContains(category, name)
//		using custom query
		List<ProductDto> productDtos = productRepository.findByCatAndName(category, "%"+name+"%")		
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this catgeory and name not found");
	return productDtos;
	}

	@Override
	public List<ProductDto> getByCategory(String category) throws ProductNotFoundException {
		List<ProductDto> productDtos = productRepository.findByCat(category)
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this cate not found");
	return productDtos;
	}

	@Override
	public List<ProductDto> getByBrandAndLessPrice(String brand, double price) throws ProductNotFoundException {
		List<ProductDto> productDtos = productRepository.findByBrandPrice(brand, price)
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this brand price not found");
	return productDtos;
	}

	@Override
	public List<ProductDto> getByNameContains(String name) throws ProductNotFoundException {
		List<ProductDto> productDtos = productRepository.findByNameContains("%"+name+"%")
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this name containing not found");
	return productDtos;
	}

	@Override
	public List<ProductDto> getByGreaterPrice(double price) {
		List<ProductDto> productDtos = productRepository.findByGreaterPrice(price)
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this price  not found");
	return productDtos;
	}

	@Override
	public List<ProductDto> getByBrandAndCat(String brand, String cat) {
		List<ProductDto> productDtos = productRepository.findByBrandAndCat(brand, cat)
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this brand cat  not found");
	return productDtos;
	}

	@Override
	public void updateProduct(long productId, double price) {
		productRepository.updateProduct(productId, price);		
	}

	@Override
	public List<ProductDto> getSortedProducts(String propertyName) {
		Sort sortType = Sort.by(Direction.DESC, propertyName);
		List<ProductDto> productDtos = productRepository.findAll(sortType)
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		return productDtos;
	}

	@Override
	public List<ProductDto> getPagedProducts(int pageNo, int pageSize) {
		
		Pageable pageable = Pageable.ofSize(pageSize);
		List<ProductDto> productDtos = productRepository.findAll(pageable)
				.stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		return productDtos;
	}

	@Override
	public List<ProductDto> getByBrand(String propertyName, String brand) throws ProductNotFoundException {
		Sort sortType = Sort.by(Direction.ASC, propertyName);
		List<ProductDto> productDtos = productRepository.findBybrand(sortType, brand).stream()
				//convert one by one entity to dto object
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty())
			throw new ProductNotFoundException("produt with this brand not found");
	return productDtos;
	}

}
