package com.bookstore.bookmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookmanagementsystem.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
