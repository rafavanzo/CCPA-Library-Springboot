package com.rafael.ccpasystembackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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


}
