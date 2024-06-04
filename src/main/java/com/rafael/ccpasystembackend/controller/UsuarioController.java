package com.rafael.ccpasystembackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.ccpasystembackend.model.Usuario;
import com.rafael.ccpasystembackend.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioController {
    // Irei codar esta parte ainda hoje.

    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    public static final String USUARIO = "usuario";

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario, HttpServletRequest request) {
        Usuario usuarioExistente = usuarioRepository.findByUsu(usuario.getUsu());
        if (usuarioExistente != null && usuarioExistente.getSenha().equals(usuario.getSenha())) {
            HttpSession session = request.getSession();
            session.setAttribute(USUARIO, usuarioExistente);
            return ResponseEntity.ok(usuarioExistente);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndpoint(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(USUARIO) != null) {
            Usuario usuario = (Usuario) session.getAttribute(USUARIO);
            return ResponseEntity.ok(usuario.getUsu());
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok().build();
    }
}