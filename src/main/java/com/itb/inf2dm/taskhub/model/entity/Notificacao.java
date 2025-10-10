package com.itb.inf2dm.taskhub.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer idUsuario;

    @Column(nullable = false, length = 20)
    private String statusNotificacao;

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

    public String getStatusNotificacao() {
        return statusNotificacao;
    }

    public void setStatusNotificacao(String statusNotificacao) {
        this.statusNotificacao = statusNotificacao;
    }
}
