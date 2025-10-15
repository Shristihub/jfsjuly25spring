package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name="product_details")  // to give a different table name
@NamedQuery(name = "findByBrandCat",
            query="from Product p where p.brand=?1 and p.category=?2")

@NamedQueries(value = {
		@NamedQuery(name = "findByBrandAndPrice",
	            query="from Product p where p.brand=?1 and p.price=?2"),
		@NamedQuery(name = "findByCat",
        query="from Product p where p.category=?1")
})

public class Product {

	@Column(length = 20)
	private String productName;
	@Id
	@GeneratedValue
	private Long productId;
	@Column(length = 20)
	private String brand;
	@Column(length = 20)
	private String category;
	@Column(name="cost")
	private double price;
	
	
}


//product
//product_seq




