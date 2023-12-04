package com.libraryservice.dto.mapper;

import org.mapstruct.Mapper;

import com.libraryservice.dtos.AuthorDto;
import com.libraryservice.dtos.AuthorSlimDto;
import com.libraryservice.dtos.BookDto;
import com.libraryservice.dtos.BookSlimDto;
import com.libraryservice.entity.Author;
import com.libraryservice.entity.Book;


@Mapper
public interface MapStructMapper {
	
	 BookSlimDto bookToBookSlimDto(Book book); 
	 Book bookDtoToBook(BookDto  bookDto);
	 BookDto bookToBookDto(Book book); 
	 AuthorDto  authorToAuthorDto(Author author); 
	 AuthorSlimDto authorToAuthorSlimDto(Author author); 
	 Author authorSlimDtoToAuthor(AuthorSlimDto authorPostDto);
	 
}