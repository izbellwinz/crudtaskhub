package com.itb.inf2dm.taskhub.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Base64;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;               // INT IDENTITY

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 100, nullable = false)
    private String senha;

    @Column(name = "nivelAcesso", length = 20, nullable = false)
    private String nivelAcesso;

    @Lob
    @Column(name = "foto", columnDefinition = "varbinary(max)", nullable = true)
    @JsonIgnore // não serializar o array de bytes cru
    private byte[] foto;

    @Column(name = "dataCadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "statusUsuario", length = 20, nullable = false)
    private String statusUsuario;

    public Usuario() {
    }

    @PrePersist
    public void prePersist() {
        if (this.dataCadastro == null) {
            this.dataCadastro = LocalDateTime.now();
        }
        if (this.nivelAcesso == null) {
            this.nivelAcesso = "USER"; // conforme combinado
        }
        if (this.statusUsuario == null) {
            this.statusUsuario = "ATIVO";
        }
    }

    // getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    // Para retornar a foto no JSON como base64 em vez do array de bytes cru
    @JsonProperty("foto")
    public String getFotoBase64() {
        if (this.foto == null) return null;
        return Base64.getEncoder().encodeToString(this.foto);
    }

    // opcional: permitir setar foto via base64 (não será usado automaticamente pelo Jackson sem customização)
    @JsonProperty("foto")
    public void setFotoBase64(String base64) {
        if (base64 == null || base64.isBlank()) {
            this.foto = null;
        } else {
            this.foto = Base64.getDecoder().decode(base64);
        }
    }
}