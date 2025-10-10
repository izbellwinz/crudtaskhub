package com.itb.inf2dm.taskhub.controller;


import com.itb.inf2dm.taskhub.model.entity.Agenda;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/agenda")
public class AgendaController {

    List<Agenda> eventos = new ArrayList<Agenda>();

    @GetMapping
    public List<Agenda> findAll() {

        //Simulado - Criando um item da agenda
        Agenda a1 = new Agenda();
        a1.setTitulo("Reunião com o grupo do TCC");
        a1.setHora(LocalTime.of(13, 30));
        a1.setDescricao("Vamos discutir sobre o projeto e o andamento de cada documento");


        eventos.add(a1);

        return eventos;
    }
}
