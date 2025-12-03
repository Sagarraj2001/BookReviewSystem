package com.backend.Backend.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String reviewerName;
	private Integer rating;
	private String comment;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "book_id")
	private Book book;


}
