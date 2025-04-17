package com.example.Biblioteca_Jpa.dto;

import com.example.Biblioteca_Jpa.entity.Cliente;
import com.example.Biblioteca_Jpa.entity.Emprestimo;
import com.example.Biblioteca_Jpa.entity.Livro;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class EmprestimoDto implements Serializable {
    private Long idEmprestimo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Cliente cliente;
    private List<Livro> livros;

    public Emprestimo toEmprestimo(){
        return new Emprestimo(
                this.idEmprestimo,
                this.dataInicial,
                this.dataFinal,
                this.getCliente(),
                this.livros
        );
    }

    public EmprestimoDto fromEmprestimo(Emprestimo emprestimo){
        return new EmprestimoDto(
                emprestimo.getIdEmprestimo(),
                emprestimo.getDataInicial(),
                emprestimo.getDataFinal(),
                emprestimo.getCliente(),
                emprestimo.getLivros()
        );
    }


    public EmprestimoDto() {
    }

    public EmprestimoDto(Long idEmprestimo, LocalDate dataInicial, LocalDate dataFinal, Cliente cliente, List<Livro> livros) {
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
