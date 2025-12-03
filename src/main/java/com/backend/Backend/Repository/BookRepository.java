package com.backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Backend.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
