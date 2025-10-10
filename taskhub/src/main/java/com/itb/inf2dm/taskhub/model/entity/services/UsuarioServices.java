package com.itb.inf2dm.taskhub.model.entity.services;

import com.itb.inf2dm.taskhub.model.entity.Usuario;
import com.itb.inf2dm.taskhub.model.entity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuários
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Buscar usuário por ID
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id " + id));
    }

    // Criar novo usuário
    public Usuario save(Usuario usuario) {
        if (usuario.getEmail() != null && usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado: " + usuario.getEmail());
        }

        // Define valores padrão
        if (usuario.getNivelAcesso() == null) {
            usuario.setNivelAcesso("USER");
        }
        if (usuario.getStatusUsuario() == null) {
            usuario.setStatusUsuario("ATIVO");
        }

        return usuarioRepository.save(usuario);
    }

    // Atualizar usuário existente
    public Usuario update(Long id, Usuario dados) {
        Usuario existente = findById(id);

        if (dados.getNome() != null) existente.setNome(dados.getNome());
        if (dados.getEmail() != null && !dados.getEmail().equals(existente.getEmail())) {
            if (usuarioRepository.existsByEmail(dados.getEmail())) {
                throw new RuntimeException("Email já cadastrado: " + dados.getEmail());
            }
            existente.setEmail(dados.getEmail());
        }
        if (dados.getSenha() != null) existente.setSenha(dados.getSenha());
        if (dados.getFoto() != null) existente.setFoto(dados.getFoto());
        if (dados.getStatusUsuario() != null) existente.setStatusUsuario(dados.getStatusUsuario());

        // Nível de acesso sempre USER (regra de negócio)
        existente.setNivelAcesso("USER");

        return usuarioRepository.save(existente);
    }

    // Excluir usuário (remoção física)
    public void delete(Long id) {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }

    // Desativar usuário (soft delete)
    public Usuario desativar(Long id) {
        Usuario usuario = findById(id);
        usuario.setStatusUsuario("INATIVO");
        return usuarioRepository.save(usuario);
    }

    // Login simples (email + senha)
    public Usuario login(String email, String senha) {
        Optional<Usuario> usuarioOpt = Optional.ofNullable(usuarioRepository.findByEmailAndSenha(email, senha));
        return usuarioOpt.orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
    }
}