package com.rafael.ccpasystembackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rafael.ccpasystembackend.model.Livro;
import com.rafael.ccpasystembackend.repository.LivroRepository;

@SpringBootApplication
public class CcpasystembackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcpasystembackendApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(LivroRepository livroRepository) {
		return args -> {
			livroRepository.deleteAll();

			Livro l = new Livro();
			l.setCodigo("123");
			l.setTitulo("O Senhor dos Anéis");
			l.setEditora("Martins Fontes");
			l.setDataLancamento("01/01/2001");
			l.setAutor("J. R. R. Tolkien");
			l.setGenero("Fantasia");

			livroRepository.save(l);
		};
	}
}
