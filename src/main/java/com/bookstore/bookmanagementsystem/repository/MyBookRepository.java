package com.bookstore.bookmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookmanagementsystem.entity.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
