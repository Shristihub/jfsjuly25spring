package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.ProductDto;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappDatajpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappDatajpaApplication.class, args);
	}


	@Autowired
	private IProductService productService;
	
	
	@Override
	public void run(String... args) throws Exception {
		ProductDto productDto = new ProductDto("Pen", null, "classmate","stationary", 200);
		productService.addProduct(productDto);
		productDto = new ProductDto("Football",null,"Nike","Sports",220);
		productService.addProduct(productDto);
		productDto = new ProductDto("Shoes",null,"Nike","Sports",4220);
		productService.addProduct(productDto);
		productDto = new ProductDto("Tennisball",2l,"Cosco","Sports",520);
		productService.addProduct(productDto);
		productDto = new ProductDto("Notebook",null,"Classmate","Stationary",120);
		productService.addProduct(productDto);
		productDto = new ProductDto("Basketball",null,"Cosco","Sports",1220);
		productService.addProduct(productDto);
		
		System.out.println();
		productService.getAll().stream().forEach(System.out::println);
		System.out.println();
		ProductDto nproduct =  productService.getById(1L);
		System.out.println(nproduct);
		System.out.println();
		// for updating
		nproduct.setProductName("Ballpoint pen");
		nproduct.setPrice(240);
		productService.updateProduct(nproduct);
		System.out.println();
//		productService.deleteProduct(5);
		
//		System.out.println();
//		System.out.println("BY brand");
//		productService.getByBrand("Cosco").stream().forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("BY lesser price");
//		productService.getByLesserPrice(3000).stream().forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("BY cat and name");
//		productService.getByCategoryandNameContains("Sports","ball").stream().forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("BY cat ");
//		productService.getByCategory("Sports").stream().forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("BY brand and price ");
//		productService.getByBrandAndLessPrice("Nike", 40000).stream().forEach(System.out::println);
//		System.out.println();
//		
//		
//		System.out.println("BY name contains ");
//		productService.getByNameContains("ball").stream().forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("BY brand category ");
//		productService.getByBrandAndCat("Cosco","Sports").stream().forEach(System.out::println);
//		System.out.println();
				
//		System.out.println("BY price ");
//		productService.getByGreaterPrice(1000).stream().forEach(System.out::println);
//		System.out.println();		
//		
//		System.out.println("update product");
//		productService.updateProduct(1,560);
		
//		System.out.println("sorting");
//		productService.getSortedProducts("brand").stream().forEach(System.out::println);
//		System.out.println();
		
		System.out.println("paging");
		productService.getPagedProducts(1,4).stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("BY brand");
		productService.getByBrand("productName","Cosco").stream().forEach(System.out::println);
		System.out.println();
		
	}

}















