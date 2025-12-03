package com.backend.Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.Backend.DTO.ResponseStructure;
import com.backend.Backend.Entity.Book;
import com.backend.Backend.Service.BookService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

	@Autowired
	private BookService bookService;
	@PostMapping("/saveBook")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book){
	   return bookService.saveBook(book);
	}

	
	@GetMapping("/books")
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
	   return bookService.getAllBooks();
	}
	
	
}
