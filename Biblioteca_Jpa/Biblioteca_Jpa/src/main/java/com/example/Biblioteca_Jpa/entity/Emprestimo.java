package com.example.Biblioteca_Jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Emprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @JsonBackReference
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "emprestimo_livro",
            joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private Set<Livro> livros;

    public Emprestimo() {
    }

    public Emprestimo(Long idEmprestimo, LocalDate dataInicial, LocalDate dataFinal, Cliente cliente, Set<Livro> livros) {
        this.idEmprestimo = idEmprestimo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.livros = livros;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }
}
