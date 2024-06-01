package com.rafael.ccpasystembackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.ccpasystembackend.model.Livro;
import com.rafael.ccpasystembackend.repository.LivroRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/livros")
@AllArgsConstructor
public class LivrosController {

    private LivroRepository livroRepository;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Livro> list() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livroRepository.save(livro));
    }
}
