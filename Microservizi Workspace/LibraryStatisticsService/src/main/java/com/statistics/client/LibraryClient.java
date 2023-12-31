package com.statistics.client;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.statistics.dto.AuthorDto;
import com.statistics.dto.BookDto;

@FeignClient(name = "LibraryService")
public interface LibraryClient {
	
	@GetMapping("/api/book/instanceId")
	public String getInstanceId();
	
	@GetMapping(value = "/api/book")
	public List<BookDto> listAllBook();

	@GetMapping(value = "/api/book/genre/{genre}")
	public List<BookDto> getByGenre(@PathVariable("genre") String genre);
	
	@GetMapping(value = "/api/book/afterdate/{date}")
	public List<BookDto> getAfterPublicationDate(
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date);
	
	@GetMapping(value = "/api/author/name/{firstName}/{lastName}")
	public AuthorDto listAuthorByNameAndSurname(
			@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName);
}
