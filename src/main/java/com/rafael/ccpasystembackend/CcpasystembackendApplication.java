package com.rafael.ccpasystembackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rafael.ccpasystembackend.model.Livro;
import com.rafael.ccpasystembackend.model.Usuario;
import com.rafael.ccpasystembackend.model.Usuario.Permissao;
import com.rafael.ccpasystembackend.repository.LivroRepository;
import com.rafael.ccpasystembackend.repository.UsuarioRepository;

@SpringBootApplication
public class CcpasystembackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcpasystembackendApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
		return args -> {
			// adiciona dois livros ao banco de dados MySQL
			
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

			// adiciona dois usuarios ao banco de dados MySQL

			usuarioRepository.deleteAll();

			Usuario usuario1 = new Usuario();
			usuario1.setNome("Rafael Vanzo");
			usuario1.setEmail("rafael@email.com");
			usuario1.setUsu("220019677");
			usuario1.setSenha("password123");
			usuario1.setPermissao(Permissao.ADMIN);
			usuario1.setDataNascimento("07/12/2001");
			usuario1.setTelefone("1234567890");
			usuario1.setAtivo(true);

			Usuario usuario2 = new Usuario();
			usuario2.setNome("Maria Vitoria");
			usuario2.setEmail("maria@email.com");
			usuario2.setUsu("220019666");
			usuario2.setSenha("senha123");
			usuario2.setPermissao(Permissao.ALUNO);
			usuario2.setDataNascimento("07/12/2001");
			usuario2.setTelefone("0987654321");
			usuario2.setAtivo(true);

			usuarioRepository.save(usuario1);
			usuarioRepository.save(usuario2);
		};
	}
}
