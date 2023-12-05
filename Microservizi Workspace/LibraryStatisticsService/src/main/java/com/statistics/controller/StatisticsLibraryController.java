package com.statistics.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statistics.service.StatisticsLibraryService;

@RestController
@RequestMapping("/api/book-statistics")
public class StatisticsLibraryController {
	
	@Autowired
	StatisticsLibraryService service;
	
	@GetMapping("/instanceId")
	public String instanceId(){
		return "LibraryStatisticService calls the instance of LibraryService number: " 
				+ service.getInstance();
	}
	
	@GetMapping("/genre/{genre}")
	public ResponseEntity<String> basedGenre(@PathVariable String genre){
		
		int numbersTotal = service.numberOfTotalBooks();
		int numberOfGenre = service.basedGenre(genre);
		String result = String.format("There are %d of %d books of genre %s in the library."
                + " Percentage: %.2f.",
                numberOfGenre, numbersTotal, genre, service.percent(numberOfGenre, numbersTotal));
		return new ResponseEntity<String>(result , HttpStatus.OK);
	}
	
	@GetMapping("/date/{date}")
	public ResponseEntity<String> basedDate(
			@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date){
		
		int numbersTotal = service.numberOfTotalBooks();
		int numberOfAfterPublicationDate = service.basedPublicationDate(date);
		String result = String.format("There are %d of %d books published later %s in the library."
                + " Percentage: %.2f.",
                numberOfAfterPublicationDate, numbersTotal, date.toString(), 
                service.percent(numberOfAfterPublicationDate, numbersTotal));
		return new ResponseEntity<String>(result , HttpStatus.OK);
	}
	
	@GetMapping(value = "/name/{firstName}/{lastName}")
	public ResponseEntity<String> basedAuthor(
			@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
		String result = String.format(
				"In the library there are %d books written by %s %s.", 
				service.basedAuthor(firstName, lastName), firstName, lastName);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
