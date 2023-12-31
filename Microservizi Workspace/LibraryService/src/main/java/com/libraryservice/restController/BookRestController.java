package com.libraryservice.restController;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryservice.dtos.BookDto;
import com.libraryservice.service.LibraryService;

@RequestMapping(value = "/api/book")
@RestController
public class BookRestController {
	
	private Logger log = Logger.getLogger(BookRestController.class.getName());
	
	@Autowired
	private LibraryService service;
	
	@Value("${server.instance.id:1}")
	String instanceId;
	
	@GetMapping("/instanceId")
	public String getInstanceId() {
		return instanceId;
	}
	
	@GetMapping
	public List<BookDto> listAllBook(){
		log.info("***** Get all the books. *****");
		List<BookDto> allBook = service.selAllBooks();
		return allBook;
	}

	@GetMapping(value = "/{isbn}")
	public BookDto getByIsbn(@PathVariable("isbn") String isbn){
		log.info("*** Get the book with ISN: "+ isbn +"*****");
		BookDto book = service.selBookByIsbn(isbn);
		return book;
	}
	
	@GetMapping(value = "/genre/{genre}")
	public List<BookDto> getByGenre(@PathVariable("genre") String genre){
		log.info("***** Search for books by genre. *****");
		List<BookDto> books = service.findBooksByGenre(genre);
		return books;
	}
	
	@GetMapping(value = "/title/{title}")
	public List<BookDto> getByTitleContains(@PathVariable("title") String title){
		log.info("***** Search for books by title contains. *****");
		List<BookDto> books = service.findBooksTitleContains(title);
		return books;
	}
	
	@GetMapping(value = "/afterdate/{date}")
	public List<BookDto> getAfterPublicationDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
		log.info("***** Search for books by date.*****");
		List<BookDto> books = service.findBooksAfterPublicationDate(date);
		return books;
	}
}

