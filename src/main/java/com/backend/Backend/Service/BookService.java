package com.backend.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.Backend.DAO.BookDAO;
import com.backend.Backend.DTO.ResponseStructure;
import com.backend.Backend.Entity.Book;
import com.backend.Backend.Exception.MissingInformation;
import com.backend.Backend.Exception.NoRecordFoundException;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDao;

	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {
		ResponseStructure<Book> response = new ResponseStructure<Book>();
		Book saveBook = bookDao.saveBook(book);
		if (saveBook != null) {
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage("Book Data is Saved");
			response.setData(saveBook);
			return new ResponseEntity<ResponseStructure<Book>>(response,HttpStatus.CREATED);
		}
		throw new MissingInformation("Book data is missing");
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks(){
		ResponseStructure<List<Book>> response = new ResponseStructure<List<Book>>();
		List<Book> getBooks=bookDao.getAllBooks();
		if(!getBooks.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Book Data is Fetched");
			response.setData(getBooks);
			return new ResponseEntity<ResponseStructure<List<Book>>>(response,HttpStatus.OK);
		}
		throw new NoRecordFoundException("No data is Available");
		
	}
}
