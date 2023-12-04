package com.statistics.dto;

public class BookSlimDto {

	private String isbn;
	private String title;
	
	public BookSlimDto() {
		super();
	}

	public BookSlimDto(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
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
	
	
}
