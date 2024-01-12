package com.example.bookstore.controller;


import com.example.bookstore.entity.user;

import com.example.bookstore.respiratory.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class userController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private userRepository repo ;

    @GetMapping("/signin")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String signup(Model model){
        model.addAttribute("user", new user());
        return "register";
    }


    @PostMapping("/process-register")
    public String processRegistration(user u  , RedirectAttributes ra){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setRole("ROLE-USER");
        repo.save(u);
        ra.addFlashAttribute("msg","Registration Successfully");
        return "redirect:/register";
    }
}
