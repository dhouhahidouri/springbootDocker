package com.example.bookstore.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.respiratory.BookRepository;




@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		   
	            bRepo.save(b);
	        
	    }
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	public List<Book> searchBooks(String name, String auther) {
		// Vérifiez que les paramètres ne sont pas null
	    if (name == null) {
	        name = "";
	    }
	    if (auther == null) {
	        auther = "";
	    }
        return bRepo.findByNameContainingAndAutherContaining(name, auther);
    }
	
}
