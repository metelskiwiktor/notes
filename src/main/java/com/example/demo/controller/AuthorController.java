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
        Author author = this.authorRepository.findById(id).get();
        author.setPassword("****");
        return author;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        List<Author> authors = this.authorRepository.findAll();
        authors.forEach(author -> author.setPassword("*****"));

        return authors;
    }
}
