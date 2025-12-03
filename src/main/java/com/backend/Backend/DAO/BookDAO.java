package com.backend.Backend.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.Backend.Entity.Book;
import com.backend.Backend.Repository.BookRepository;

@Repository
public class BookDAO {

	@Autowired
	private BookRepository bookRepo;
	
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	
	
}
