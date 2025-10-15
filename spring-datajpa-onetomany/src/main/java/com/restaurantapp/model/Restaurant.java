package com.restaurantapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
	
	private String restaurantName;
	
	private Integer restaurantId;
	private String city;
	private String cuisine;
	private String category; //veg,nonveg
	
	private Set<MenuItem> menuItems;
	

}
