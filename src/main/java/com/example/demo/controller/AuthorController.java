package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author){
        this.authorRepository.save(author);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id){
        return this.authorRepository.findById(id).get();
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }
}
