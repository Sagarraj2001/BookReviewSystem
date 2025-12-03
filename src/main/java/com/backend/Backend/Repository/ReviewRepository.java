package com.backend.Backend.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Backend.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByBookId(Integer id);
}
