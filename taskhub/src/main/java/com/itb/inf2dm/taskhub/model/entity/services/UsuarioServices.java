package com.itb.inf2dm.taskhub.model.entity.services;

import com.itb.inf2dm.taskhub.model.entity.Usuario;
import com.itb.inf2dm.taskhub.model.entity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id " + id));
    }

    public Usuario save(Usuario usuario) {
        // validação simples: email único
        if (usuario.getEmail() != null && usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado: " + usuario.getEmail());
        }
        // força nivelAcesso = USER
        usuario.setNivelAcesso("USER");
        // se status não informado, será tratado no @PrePersist
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Integer id, Usuario dados) {
        Usuario existente = findById(id);
        // atualiza campos permitidos
        if (dados.getNome() != null) existente.setNome(dados.getNome());
        if (dados.getEmail() != null && !dados.getEmail().equals(existente.getEmail())) {
            // evita duplicar e permite mudar se ainda não existir
            if (usuarioRepository.existsByEmail(dados.getEmail())) {
                throw new RuntimeException("Email já cadastrado: " + dados.getEmail());
            }
            existente.setEmail(dados.getEmail());
        }
        if (dados.getSenha() != null) existente.setSenha(dados.getSenha());
        // nivelAcesso sempre USER (conforme seu requisito)
        existente.setNivelAcesso("USER");
        if (dados.getFoto() != null) existente.setFoto(dados.getFoto());
        if (dados.getStatusUsuario() != null) existente.setStatusUsuario(dados.getStatusUsuario());
        // não altera dataCadastro
        return usuarioRepository.save(existente);
    }

    // exclusão física
    public void delete(Integer id) {
        Usuario u = findById(id);
        usuarioRepository.delete(u);
    }

    // desativar (soft) -> set statusUsuario = "INATIVO"
    public Usuario desativar(Integer id) {
        Usuario u = findById(id);
        u.setStatusUsuario("INATIVO");
        return usuarioRepository.save(u);
    }

    // login simples (email + senha)
    public Usuario login(String email, String senha) {
        Usuario u = usuarioRepository.findByEmailAndSenha(email, senha);
        if (u == null) {
            throw new RuntimeException("Credenciais inválidas");
        }
        return u;
    }
}