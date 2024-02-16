package com.bookstore.bookmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookmanagementsystem.entity.Book;
import com.bookstore.bookmanagementsystem.entity.MyBookList;
import com.bookstore.bookmanagementsystem.repository.BookRepository;

@Service
public class BookSevice {

	@Autowired
	private BookRepository bookRepo;
	
	public void saveBook(Book b)
	{
		bookRepo.save(b);
	}
	
	public List<Book> getAllBook() {
		
	return	bookRepo.findAll();		
	}
	
	public Book getBookById(int id)
	{
		return bookRepo.findById(id).get();
	}
	public void deleteById(int id)
	{
		bookRepo.deleteById(id);
	}
}
