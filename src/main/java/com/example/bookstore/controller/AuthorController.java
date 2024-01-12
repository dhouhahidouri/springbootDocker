package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.bookstore.entity.Author;
import com.example.bookstore.service.AuthorService;



@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    // Injectez le service de l'auteur ici

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping()
    public String showAuthors(Model model) {
        // Récupérez la liste des auteurs depuis le service
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    
   

    @GetMapping("/register")
    public String showAuthorRegisterForm(Model model) {
        // Ajoutez un nouvel auteur à la vue pour le formulaire
        model.addAttribute("author", new Author());
        return "authorRegister";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(Author author) {
        // Enregistrez l'auteur en utilisant le service
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/editAuthor/{id}")
    public String showEditAuthorForm(@PathVariable Long id, Model model) {
        // Récupérez l'auteur par ID et ajoutez-le à la vue pour le formulaire de modification
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "authorEdit";
    }
    @RequestMapping("/deleteAuthor/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
    	authorService.deleteById(id);
		return "redirect:/authors";

    

}
}