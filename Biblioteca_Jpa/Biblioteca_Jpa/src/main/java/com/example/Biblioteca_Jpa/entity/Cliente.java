package com.example.Biblioteca_Jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;

   @OneToMany(mappedBy = "cliente")
   @JsonIgnore
   private Set<Emprestimo> emprestimos;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nome, String sobrenome, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
