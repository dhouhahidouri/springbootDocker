package com.example.bookstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Author;
import com.example.bookstore.respiratory.AuthorRepository;


@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
