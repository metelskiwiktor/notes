package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    private NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping
    public void addNote(@RequestBody Note note){
        this.noteRepository.save(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return this.noteRepository.findAll();
    }
}
