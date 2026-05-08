package com.piseth.java.school.phoneshope_night.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiException extends RuntimeException{
	private final HttpStatus status;
	private final String  message;
}
