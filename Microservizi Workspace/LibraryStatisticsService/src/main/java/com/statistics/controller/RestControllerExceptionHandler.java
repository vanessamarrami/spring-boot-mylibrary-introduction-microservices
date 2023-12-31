package com.statistics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.statistics.exception.ConnectionRefusedExceptions;
import com.statistics.exception.ErrorResponse;
import com.statistics.exception.NotFoundException;

@RestControllerAdvice
public class RestControllerExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleNoFoundException(NotFoundException ex) {
		 
		 ErrorResponse error = new ErrorResponse();
		 error.setCode(HttpStatus.NOT_FOUND.value());
		 error.setMessage(ex.getMessage());
		 return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	 }
	
	@ExceptionHandler(ConnectionRefusedExceptions.class)
	 public ResponseEntity<ErrorResponse> handleNoFoundException(ConnectionRefusedExceptions ex) {
		 
		 ErrorResponse error = new ErrorResponse();
		 error.setCode(HttpStatus.SERVICE_UNAVAILABLE.value());
		 error.setMessage(ex.getMessage());
		 return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	 }
	 
}