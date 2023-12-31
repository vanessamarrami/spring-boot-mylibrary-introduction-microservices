package com.libraryservice.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.libraryservice.exceptions.ErrorResponse;
import com.libraryservice.exceptions.NotFoundException;

@RestControllerAdvice("com.libraryservice.restController")
public class RestControllerExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleNoFoundException(NotFoundException ex) {
		 
		 ErrorResponse error = new ErrorResponse();
		 error.setCode(HttpStatus.NOT_FOUND.value());
		 error.setMessage(ex.getMessage());
		 return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	 }
	 
}