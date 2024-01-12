package com.example.bookstore.respiratory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	 List<Book> findByNameContainingAndAutherContaining(String name, String auther);

	    
}