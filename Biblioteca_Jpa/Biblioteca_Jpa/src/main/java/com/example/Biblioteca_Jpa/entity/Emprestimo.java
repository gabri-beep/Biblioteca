package com.example.Biblioteca_Jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private Date dataInicial;
    private Date dataFinal;


    @OneToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Livro> livros;

    public Emprestimo() {
    }

    public Emprestimo(Long idEmprestimo, Date dataInicial, Date dataFinal) {
        this.idEmprestimo = idEmprestimo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
