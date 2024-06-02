package com.rafael.ccpasystembackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.ccpasystembackend.model.Livro;
import com.rafael.ccpasystembackend.repository.LivroRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


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
    public ResponseEntity<Livro> get(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livroRepository.save(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        return livroRepository.findById(id)
                .map(recordFound -> 
                {
                    recordFound.setCodigo(livro.getCodigo());
                    recordFound.setTitulo(livro.getTitulo());
                    recordFound.setEditora(livro.getEditora());
                    recordFound.setDataLancamento(livro.getDataLancamento());
                    recordFound.setAutor(livro.getAutor());
                    recordFound.setGenero(livro.getGenero());
                    Livro updated = livroRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                }
                )
                .orElse(ResponseEntity.notFound().build());         
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(recordFound -> 
                {
                    livroRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                }
                )
                .orElse(ResponseEntity.notFound().build());    
    }

}
