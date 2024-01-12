package com.example.bookstore.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.MyBookListService;

import java.util.*;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	/*@Autowired
	private AuthorService authorService;*/
	
	@Autowired
	private MyBookListService myBookService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	/*@GetMapping("/book_register")
	public String bookRegister(Model model) {
		List<Author> authors = authorService.getAllAuthors();
	    model.addAttribute("authors", authors);
	    model.addAttribute("author", new Author());
	    model.addAttribute("book", new Book());  // Make sure you have this line
	    return "bookRegister";
	}*/
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuther(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	@GetMapping("/search")
	public ModelAndView searchBooks(@RequestParam(required = false) String name, @RequestParam(required = false) String auther) { // Correction ici
		if (name == null) {
	        name = "";
	    }
	    if (auther == null) {
	        auther = "";
	    }
	    System.out.println("Name: " + name);
	    System.out.println("Auther: " + auther);

		List<Book> resultList = service.searchBooks(name, auther); // Correction ici
	    return new ModelAndView("searchResult", "books", resultList);
	}
	
	
}
