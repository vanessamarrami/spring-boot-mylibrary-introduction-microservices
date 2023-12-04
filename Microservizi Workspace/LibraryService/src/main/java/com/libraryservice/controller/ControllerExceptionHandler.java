package com.libraryservice.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.libraryservice.exceptions.DuplicateException;
import com.libraryservice.exceptions.NotFoundException;


@ControllerAdvice("com.libraryservice.controller")
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errorPage");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
    
    @ExceptionHandler(DuplicateException.class)
	 public ModelAndView  handleDuplicateException(DuplicateException ex) {
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errorPage");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
	 }
}

