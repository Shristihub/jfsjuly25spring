package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.ItemType;
import com.restaurantapp.model.MenuItemDto;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringDatajpaOnetomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanyApplication.class, args);
	}

	@Autowired
	private IRestaurantService restaurantService;
	
	@Override
	public void run(String... args) throws Exception {
//		MenuItemDto item1 = new MenuItemDto("Masala Dosa",null,100,ItemType.BF.getType());
//		MenuItemDto item2 = new MenuItemDto("Panneer Fried Rice",null,150,ItemType.MAINCOURSE.getType());
//		MenuItemDto item3 = new MenuItemDto("Lemon Rice",null,80,ItemType.MAINCOURSE.getType());
//		
//		Set<MenuItemDto> menuItems = new HashSet<MenuItemDto>(Arrays.asList(item1,item2,item3));
//		
//		RestaurantDto restaurantDto =  
//		new RestaurantDto("A2B", null, "Bengaluru", Cuisine.SI.getCuisine(), Category.VEG,menuItems);
//	
////		restaurantService.addRestaurant(restaurantDto);
////		
//		item1 = new MenuItemDto("Neer Dosa",null,200,ItemType.BF.getType());
//		item2 = new MenuItemDto("Poha",null,350,ItemType.MAINCOURSE.getType());
//		item3 = new MenuItemDto("paneer lollipop",null,480,ItemType.STARTER.getType());
//		
//		menuItems = new HashSet<MenuItemDto>(Arrays.asList(item1,item2,item3));
//		
//		restaurantDto =  
//		new RestaurantDto("Udupi", null, "Bengaluru", Cuisine.SI.getCuisine(), Category.VEG,menuItems);
//		
//		restaurantService.addRestaurant(restaurantDto);
//		
//		System.out.println("Updating a restaurant");
//		RestaurantDto restaurantDto1 =  restaurantService.getById(1);
//		restaurantDto1.getMenuItems().forEach(System.out::println);
//		System.out.println();
//		//add new menu items
//		MenuItemDto newItem1 = new MenuItemDto("Brownie",null,230,ItemType.DESSERT.getType());
//		MenuItemDto newItem2 = new MenuItemDto("Vada",null,130,ItemType.DESSERT.getType());
//		Set<MenuItemDto> menuItems1 = new HashSet<MenuItemDto>(Arrays.asList(newItem1,newItem2));
//		//set the menus to the restaurant
//		restaurantDto1.getMenuItems().addAll(menuItems1);
//		restaurantDto1.setCity("Chennai");
//		restaurantService.updateRestaurant(restaurantDto1);
		
		
		System.out.println("Getting all restaurant");
		restaurantService.getAll().forEach(rest->{
			System.out.println(rest.getRestaurantName());
			System.out.println(rest.getCity());
			System.out.println(rest.getCuisine());
			rest.getMenuItems().forEach(System.out::println);
		});
		
		System.out.println();
		System.out.println("Getting all restaurant by category");
		restaurantService.getByCategory(Category.VEG).forEach(rest->{
			System.out.println(rest.getRestaurantName());
			System.out.println(rest.getCuisine());
			rest.getMenuItems().forEach(System.out::println);
		});
		
		System.out.println();
		System.out.println("Getting all restaurant by category");
		restaurantService.getByItemNameContains("Rice").forEach(rest->{
			System.out.println(rest.getRestaurantName());
			System.out.println(rest.getCuisine());
			rest.getMenuItems().forEach(System.out::println);
		});
		
		
		
		
		
		
		
		
		
		
		
	}

}
