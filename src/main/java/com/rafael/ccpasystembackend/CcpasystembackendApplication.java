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
			// adicione dois livros ao banco de dados H2
			
			livroRepository.deleteAll();

			Livro l = new Livro();
			l.setCodigo("1");
			l.setTitulo("O Senhor dos Anéis");
			l.setEditora("HarperCollins");
			l.setDataLancamento("29/07/1954");
			l.setAutor("J. R. R. Tolkien");
			l.setGenero("Fantasia");
			
			Livro l2 = new Livro();
			l2.setCodigo("2");
			l2.setTitulo("Harry Potter e a Pedra Filosofal");
			l2.setEditora("Rocco");
			l2.setDataLancamento("26/06/1997");
			l2.setAutor("J. K. Rowling");
			l2.setGenero("Fantasia");

			livroRepository.save(l);
			livroRepository.save(l2);
		};
	}
}
