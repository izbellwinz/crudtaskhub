package com.itb.inf2dm.taskhub.controller;


import com.itb.inf2dm.taskhub.model.entity.Configuracao;
import com.itb.inf2dm.taskhub.model.entity.Notificacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notificacao")
public class NotificacaoController {

    List<Notificacao> notificacao = new ArrayList<Notificacao>();

    @GetMapping
    public List<Notificacao> findAll() {


        return notificacao;
    }
}
