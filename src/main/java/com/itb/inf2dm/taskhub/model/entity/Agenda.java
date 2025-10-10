package com.itb.inf2dm.taskhub.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "Agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer idUsuario;

    @Column(nullable = false)
    private LocalDate dataAgenda;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(length = 200)
    private String descricao;

    private byte[] arquivo;

    @Column(nullable = false, length = 20)
    private String statusAgenda;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(LocalDate dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getStatusAgenda() {
        return statusAgenda;
    }

    public void setStatusAgenda(String statusAgenda) {
        this.statusAgenda = statusAgenda;
    }
}
