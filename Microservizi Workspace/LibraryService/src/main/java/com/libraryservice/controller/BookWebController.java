package com.libraryservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libraryservice.dtos.AuthorSlimDto;
import com.libraryservice.dtos.BookDto;
import com.libraryservice.service.LibraryService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/library")
public class BookWebController {
	
	@Autowired
	LibraryService service;
	
	@GetMapping
	public String listAllBook(Model model){
		List<BookDto> allBook = service.selAllBooks();
		model.addAttribute("books", allBook);
		return "books";
	}
	
	@GetMapping(value = "/{isbn}")
	public String getBookByIsbn(@PathVariable String isbn, Model model){
		BookDto book = service.selBookByIsbn(isbn);
		model.addAttribute("book", book);
		return "detBook";
	} 
	
	@GetMapping(value = "/delete/{isbn}")
	public String  deleteBook(@PathVariable String isbn, Model model) {
		service.delBook(isbn);
		return "redirect:http://localhost:8765/LIBRARYSERVICE/library";
	}
	
	/*metodo per ottenere la vista di inserimento: */
	@GetMapping("/insert")
	public String newBook(Model model) {
		BookDto bookDto = new BookDto();
		model.addAttribute("message", "New Book");
		String authorNames = "";
		model.addAttribute("authorNames", authorNames);
		model.addAttribute("bookDto", bookDto);
		return "editBook";
	}
	
	/*metodo per elaborare i dati della vista di inserimento: */
	@PostMapping("/insert/saveNewBook")
	public String saveNewBook(Model model, @Valid @ModelAttribute BookDto book, BindingResult result, @ModelAttribute("authorNames") String authorNames) {
		 if (result.hasErrors()) {
			 model.addAttribute("message", "New Book");
	         return "editBook";
	        }
		Set<AuthorSlimDto> authors = service.fillAuthorsSetByStringName(authorNames);
	    book.setAuthors(authors);
		service.insertNewBook(book);
		return "redirect:http://localhost:8765/LIBRARYSERVICE/library"; 
	}
	
	@GetMapping("/update/{isbn}")
	public String updateBook(Model model, @PathVariable String isbn) {
		BookDto bookDto = service.selBookByIsbn(isbn);
		String authorNames = service.fillStringNameBySet(bookDto.getAuthors());
		model.addAttribute("authorNames", authorNames);
		model.addAttribute("bookDto", bookDto);
		model.addAttribute("message", "Edit Book");
		return "editBook";
	}
	
	@PostMapping("/update/saveBook")
	public String saveBook(Model model, @Valid @ModelAttribute("bookDto") BookDto book,  BindingResult result, @ModelAttribute("authorNames") String authorNames) {
		Set<AuthorSlimDto> authors = service.fillAuthorsSetByStringName(authorNames);
	    book.setAuthors(authors);
		if (result.hasErrors()) {
	        model.addAttribute("authorNames", service.fillStringNameBySet(book.getAuthors()));
	        model.addAttribute("message", "Edit Book");
            return "editBook";
        }
		service.saveBook(book);
		return "redirect:http://localhost:8765/LIBRARYSERVICE/library";
	}
	
	@GetMapping(value = "/genre/{genre}")
	public String findByGenre(Model model, @PathVariable String genre) {
		List<BookDto> books = service.findBooksByGenre(genre);
		model.addAttribute("books", books);
		return "books";
	}
	
	@GetMapping(value = "/afterDate/{date}")
	public String findByDate(Model model, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		List<BookDto> books = service.findBooksAfterPublicationDate(date);
		model.addAttribute("books", books);
		return "books";
	}

	 @GetMapping(value = "/title/{titleFound}")
	 public String findByTitleContains(Model model, @PathVariable("titleFound") String title) {
	     List<BookDto> books = service.findBooksTitleContains(title);
	     model.addAttribute("books", books);
	     model.addAttribute("AllBooks", true);
	     return "books";
	    }

	  @PostMapping(value = "/title")
	  public String findByTitlePost(@RequestParam("titleFound") String title) {
	        return "redirect:http://localhost:8765/LIBRARYSERVICE/library/title/" + title;
	  }
	
	
}

