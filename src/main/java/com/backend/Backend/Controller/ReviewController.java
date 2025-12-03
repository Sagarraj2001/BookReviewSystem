package com.backend.Backend.Controller;

import com.backend.Backend.DTO.ResponseStructure;
import com.backend.Backend.Entity.Review;
import com.backend.Backend.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{bookId}")
    public ResponseEntity<ResponseStructure<Review>> saveReview(
            @PathVariable Integer bookId,
            @RequestBody Review review) {
        return reviewService.saveReview(bookId, review);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<ResponseStructure<List<Review>>> getReviews(
            @PathVariable Integer bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }
}
