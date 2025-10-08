package com.itb.inf2dm.taskhub.controller;


import com.itb.inf2dm.taskhub.model.entity.Agenda;
import com.itb.inf2dm.taskhub.model.entity.Configuracao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/configuracao")
public class ConfiguracaoController {

    List<Configuracao> configuracao = new ArrayList<Configuracao>();

    @GetMapping
    public List<Configuracao> findAll() {


        return configuracao;
    }
}