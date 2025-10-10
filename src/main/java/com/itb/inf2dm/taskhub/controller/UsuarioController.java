package com.itb.inf2dm.taskhub.controller;

import com.itb.inf2dm.taskhub.model.entity.Usuario;
import com.itb.inf2dm.taskhub.model.entity.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin

public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioService;

    // DTO para receber/atualizar usuário via JSON (foto como base64)
    public static class UsuarioRequest {
        public String nome;
        public String email;
        public String senha;
        public String foto; // base64 ou null
        public String statusUsuario; // opcional
    }

    public static class LoginRequest {
        public String email;
        public String senha;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario u = usuarioService.findById(id);
        return ResponseEntity.ok(u);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioRequest req) {
        Usuario u = new Usuario();
        u.setNome(req.nome);
        u.setEmail(req.email);
        u.setSenha(req.senha);
        if (req.foto != null) {
            byte[] fotoBytes = Base64.getDecoder().decode(req.foto);
            u.setFoto(fotoBytes);
        }
        if (req.statusUsuario != null) u.setStatusUsuario(req.statusUsuario);
        Usuario salvo = usuarioService.save(u);
        URI location = URI.create("/api/v1/usuario/" + salvo.getId());
        return ResponseEntity.created(location).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody UsuarioRequest req) {
        Usuario dados = new Usuario();
        dados.setNome(req.nome);
        dados.setEmail(req.email);
        dados.setSenha(req.senha);
        if (req.foto != null) {
            dados.setFoto(Base64.getDecoder().decode(req.foto));
        }
        if (req.statusUsuario != null) dados.setStatusUsuario(req.statusUsuario);
        Usuario atualizado = usuarioService.update(id, dados);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Desativar (soft) — define statusUsuario = "INATIVO"
    @PostMapping("/{id}/desativar")
    public ResponseEntity<Usuario> desativar(@PathVariable Long id) {
        Usuario u = usuarioService.desativar(id);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest req) {
        Usuario u = usuarioService.login(req.email, req.senha);
        return ResponseEntity.ok(u);
    }
}