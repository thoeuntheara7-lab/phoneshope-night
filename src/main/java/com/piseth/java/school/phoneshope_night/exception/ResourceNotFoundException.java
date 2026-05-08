package com.piseth.java.school.phoneshope_night.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{

	public ResourceNotFoundException(String resourceName, Integer id) {
		super(HttpStatus.NOT_FOUND, String.format("%s with id = %d not found", resourceName,id));
		
		// TODO Auto-generated constructor stub
	}

	

}
