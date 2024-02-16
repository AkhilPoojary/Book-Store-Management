package com.bookstore.bookmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookmanagementsystem.entity.Book;
import com.bookstore.bookmanagementsystem.entity.MyBookList;
import com.bookstore.bookmanagementsystem.repository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepository myBookRepo;
	
	public void saveMyBook(MyBookList mybook)
	{
		myBookRepo.save(mybook);
	}

	public List<MyBookList> getAllMyBooks()
	{
		return myBookRepo.findAll();
	}
	
	public void deleteById(int id)
	{
		myBookRepo.deleteById(id);
	}
	
}
