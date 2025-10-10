package com.itb.inf2dm.taskhub.model.entity.repository;

import com.itb.inf2dm.taskhub.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmailAndSenha(String email, String senha);

    boolean existsByEmail(String email);
}