package com.rafael.ccpasystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.ccpasystembackend.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
