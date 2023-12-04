package com.statistics.dto;

import java.util.Set;

public class AuthorDto {

	private Long id;
	private String firstName;
	private String lastName;
	private Set<BookSlimDto> books;
	
	public AuthorDto() {
		super();
	}

	public AuthorDto(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<BookSlimDto> getBooks() {
		return books;
	}

	public void setBooks(Set<BookSlimDto> books) {
		this.books = books;
	}
}
