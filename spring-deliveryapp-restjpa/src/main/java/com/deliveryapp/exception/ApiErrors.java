package com.deliveryapp.exception;

import java.time.LocalDateTime;
import java.util.Set;

import com.deliveryapp.model.Address;
import com.deliveryapp.model.Brand;
import com.deliveryapp.model.Category;
import com.deliveryapp.model.Cuisine;
import com.deliveryapp.model.MenuItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiErrors {

	LocalDateTime timestamp;
	int status;
	String message;
	String error;
	
}
