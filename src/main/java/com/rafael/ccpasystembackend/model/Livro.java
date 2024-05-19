package com.rafael.ccpasystembackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
//@Table(name = "livros")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    @JsonProperty("_idLivro")
    private Long idLivro;
    
    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String editora;

    @Column(nullable = false)
    private String dataLancamento;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String genero;
}
