package com.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemType {

	STARTER("STARTER"),
	MAINCOURSE("MAIN COURSE"),
	DESSERT("DESSERT"),
	BF("BREAKFAST");
	
    String type;	
	
}
