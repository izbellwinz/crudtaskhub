package com.itb.inf2dm.taskhub.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Configuracao")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer idUsuario;

    @Column(length = 15)
    private String primeiroDiaSemana;

    @Column(nullable = false, length = 10)
    private String formatoHora;

    @Column(length = 20)
    private String tema;

    @Column(nullable = false)
    private Boolean mostrarEmail;

    @Column(nullable = false)
    private Boolean receberEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimeiroDiaSemana() {
        return primeiroDiaSemana;
    }

    public void setPrimeiroDiaSemana(String primeiroDiaSemana) {
        this.primeiroDiaSemana = primeiroDiaSemana;
    }

    public String getFormatoHora() {
        return formatoHora;
    }

    public void setFormatoHora(String formatoHora) {
        this.formatoHora = formatoHora;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getMostrarEmail() {
        return mostrarEmail;
    }

    public void setMostrarEmail(Boolean mostrarEmail) {
        this.mostrarEmail = mostrarEmail;
    }

    public Boolean getReceberEmail() {
        return receberEmail;
    }

    public void setReceberEmail(Boolean receberEmail) {
        this.receberEmail = receberEmail;
    }
}
