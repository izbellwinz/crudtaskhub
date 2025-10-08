package com.itb.inf2dm.taskhub.controller;


import com.itb.inf2dm.taskhub.model.entity.Configuracao;
import com.itb.inf2dm.taskhub.model.entity.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    List<Usuario> usuario = new ArrayList<Usuario>();

    @GetMapping
    public List<Usuario> findAll() {


        return usuario;
    }
}