package com.example.Biblioteca_Jpa.dto;

import com.example.Biblioteca_Jpa.entity.Cliente;

public class ClienteDto {
    private Long idCliente;
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente toCliente(){
        return new Cliente(
                this.idCliente,
                this.nome,
                this.sobrenome,
                this.cpf
        );
    }

    public ClienteDto fromCliente(Cliente cliente){
        return new ClienteDto(cliente.getIdCliente(), cliente.getNome(), cliente.getSobrenome(), cliente.getCpf());
    }


    public ClienteDto() {
    }

    public ClienteDto(Long idCliente, String nome, String sobrenome, String cpf) {
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
