package com.backend.Backend.Entity;

import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String author;
	private String genre;
	private String url;
	

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Review> reviews;

}
