package com.backend.Backend.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.Backend.Entity.Review;
import com.backend.Backend.Repository.ReviewRepository;

@Repository
public class ReviewDAO {

	@Autowired
	private ReviewRepository reviewRepo;
	
	public Review saveReview(Review review) {
		return reviewRepo.save(review);
	}
	
	public List<Review> getReviewsByBookId(Integer bookId){
		return reviewRepo.findByBookId(bookId);
	}
}
