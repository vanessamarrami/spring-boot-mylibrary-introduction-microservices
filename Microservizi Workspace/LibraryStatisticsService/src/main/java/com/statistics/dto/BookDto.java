package com.statistics.dto;

import java.time.LocalDate;
import java.util.Set;

public class BookDto {
	
	private String isbn;
	private String title;
	private String genre;
	private String plot;
	private LocalDate publicationDate;
	private int numberPages;
	private Set<AuthorSlimDto> authors;
	
	public BookDto() {
		super();
	}
	
	public BookDto(String isbn, String title, String genre, String plot, LocalDate publicationDate, int numberPages,
			Set<AuthorSlimDto> authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
		this.plot = plot;
		this.publicationDate = publicationDate;
		this.numberPages = numberPages;
		this.authors = authors;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public int getNumberPages() {
		return numberPages;
	}
	
	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}
	
	public Set<AuthorSlimDto> getAuthors() {
		return authors;
	}
	
	public void setAuthors(Set<AuthorSlimDto> authors) {
		this.authors = authors;
	}
	
	
}
