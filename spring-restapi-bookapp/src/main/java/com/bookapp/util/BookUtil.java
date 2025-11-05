package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookUtil {
	 public List<Book> showBooks(){
		   return Arrays.asList(
				  new Book("Java in Action",1, "Kathy"),
				  new Book("Seven Habits",2, "Steve"),
				  new Book("HeadFirst Java",3, "Kathy"),
				  new Book("Biography of Yogi",4, "Yogi"),
				  new Book("COnversation",5, "Stephen")   
				   );
	   }

	
}
