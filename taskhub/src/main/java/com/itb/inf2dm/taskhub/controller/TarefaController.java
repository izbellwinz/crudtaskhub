package com.itb.inf2dm.taskhub.controller;


import com.itb.inf2dm.taskhub.model.entity.Agenda;
import com.itb.inf2dm.taskhub.model.entity.Tarefa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefa")
public class TarefaController {

    List<Tarefa> tarefa = new ArrayList<Tarefa>();

    @GetMapping
    public List<Tarefa> findAll() {

        return tarefa;
    }
}