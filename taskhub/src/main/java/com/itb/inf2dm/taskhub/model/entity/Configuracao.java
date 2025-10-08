package com.itb.inf2dm.taskhub.model.entity;

public class Configuracao {

    private Long id;
    private String primeiroDiaSemana;
    private String formatoHora;
    private String tema;
    private String mostrarEmail;
    private String receberEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMostrarEmail() {
        return mostrarEmail;
    }

    public void setMostrarEmail(String mostrarEmail) {
        this.mostrarEmail = mostrarEmail;
    }

    public String getReceberEmail() {
        return receberEmail;
    }

    public void setReceberEmail(String receberEmail) {
        this.receberEmail = receberEmail;
    }
}
