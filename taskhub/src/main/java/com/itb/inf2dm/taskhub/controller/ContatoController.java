package com.itb.inf2dm.taskhub.controller;


import com.itb.inf2dm.taskhub.model.entity.Contato;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contato")
public class ContatoController {

    List<Contato> contatos = new ArrayList<Contato>();

    @GetMapping
    public List<Contato> findAll() {

        //Simulado - Criando um item da contato
        Contato c1 = new Contato();
        c1.setNome("Ana Souza");
        c1.setEmail("ana.souza@email.com");
        c1.setAssunto("Quero comentar que esse site é de excelente ajuda para minha rotina, queria tirar uma dúvida");
        c1.setDataEnvio("07/10/2025");

        contatos.add(c1);

        return contatos;

        //tcc
    }
}