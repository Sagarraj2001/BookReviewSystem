package com.backend.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.backend.Backend.DAO.ReviewDAO;
import com.backend.Backend.DTO.ResponseStructure;
import com.backend.Backend.Entity.Book;
import com.backend.Backend.Entity.Review;
import com.backend.Backend.Exception.IdNotFoundException;
import com.backend.Backend.Exception.NoRecordFoundException;
import com.backend.Backend.Repository.BookRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDao;

	@Autowired
	private BookRepository bookRepo;

	public ResponseEntity<ResponseStructure<List<Review>>> getReviewsByBookId(Integer bookId) {
		ResponseStructure<List<Review>> response = new ResponseStructure<>();
		List<Review> allReviews = reviewDao.getReviewsByBookId(bookId);
		if (!allReviews.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Reviews fetched successfully");
			response.setData(allReviews);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		throw new NoRecordFoundException("No reviews found for bookId: " + bookId);
	}

	public ResponseEntity<ResponseStructure<Review>> saveReview(Integer bookId, Review review) {
		ResponseStructure<Review> response = new ResponseStructure<>();
		Book book = bookRepo.findById(bookId)
				.orElseThrow(() -> new IdNotFoundException("Book not found with id: " + bookId));
		review.setBook(book);
		Review savedReview = reviewDao.saveReview(review);
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Review submitted successfully");
		response.setData(savedReview);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
