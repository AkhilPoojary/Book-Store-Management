package com.bookstore.bookmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bookmanagementsystem.entity.Book;
import com.bookstore.bookmanagementsystem.entity.MyBookList;
import com.bookstore.bookmanagementsystem.service.BookSevice;
import com.bookstore.bookmanagementsystem.service.MyBookService;

@Controller
public class BookController {

	@Autowired
	private BookSevice bookSevice;
	
	@Autowired
	private MyBookService myBookService;

	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBooks()
	{
		List<Book> allBook = bookSevice.getAllBook();
//		ModelAndView model=new ModelAndView();
//		model.setViewName("booklist");
//		model.addObject("book",allBook);
		return new ModelAndView("booklist","book",allBook);
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		bookSevice.saveBook(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		
		List<MyBookList> allMyBooks = myBookService.getAllMyBooks();
		model.addAttribute("book",allMyBooks);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book book = bookSevice.getBookById(id);
		MyBookList myBook=new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
		myBookService.saveMyBook(myBook);
		return "redirect:/my_books";
	}
	
	@RequestMapping("{/editbook/{id}")
	public String editBook(@PathVariable("id") int id,Model model)
	{
		
		Book bookById = bookSevice.getBookById(id);
		model.addAttribute("book", bookById);
		return "bookedit";
	}
	
	@RequestMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id")int id)
	{
		bookSevice.deleteById(id);
		return "redirect:/available_books";
	}
}
