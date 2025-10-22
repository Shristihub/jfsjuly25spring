package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;

public interface IRestaurantRespository extends JpaRepository<Restaurant, Integer> {

	// derived query
	List<Restaurant> findByCity(String city);
	List<Restaurant> findByCityAndCuisine(String city, String cuisine);// chennai, chinese

	@Query("from Restaurant r inner join r.menuItems mi where mi.itemType=?1and r.cuisine=?2 ")
	List<Restaurant> findByItemTypeCuisine(String itemType, String cuisine); // chinese starters

	@Query("from Restaurant r where r.category=?1 ")
	List<Restaurant> findByCategory(Category category); // veg

	@Query("""
			from Restaurant r inner join r.menuItems mi where 
			mi.itemType=?2and r.category=?1 
			""")
	List<Restaurant> findByCategoryItemType(Category category, String itemType); // veg starters

	@Query("""
			from Restaurant r inner join r.menuItems mi where 
			mi.itemName like ?2and r.category=?1 
			""")
	List<Restaurant> findByCategoryItemName(Category category, String itemName);// veg, paneer

	@Query("""
			from Restaurant r inner join r.menuItems mi where mi.itemName like ?1 
			
			""")
	List<Restaurant> findByItemNameContains(String itemName);// paneer

	@Query("""
			from Restaurant r inner join r.menuItems mi where mi.itemName like ?1 
			and mi.price <?2
			""")
	List<Restaurant> findByItemNameLessPrice(String itemName, double price);

}
