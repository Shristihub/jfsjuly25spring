package com.restaurantapp.model;

public enum Cuisine {
     NI("NORTH INDIAN"),
     SI("SOUTH INDIAN"),
     CHINESE("CHINESE"),
     ITALIAN("ITALIAN"),
     MEXICAN("MEXICAN");
     
     private String cuisine;
  
	private Cuisine(String cuisine){
    	 this.cuisine=cuisine;
     }
	   
    public String getCuisine() {
		return cuisine;
	}

	
}
