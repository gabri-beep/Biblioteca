package com.example.Biblioteca_Jpa.dto;

import com.example.Biblioteca_Jpa.entity.Cliente;
import com.example.Biblioteca_Jpa.entity.Emprestimo;
import com.example.Biblioteca_Jpa.entity.Livro;

import java.util.Date;
import java.util.List;

public class EmprestimoDto {
    private Long idEmprestimo;
    private Date dataInicial;
    private Date dataFinal;
    private Cliente cliente;
    private List<Livro> livros;

    public Emprestimo toEmprestimo(){
        return new Emprestimo(this.idEmprestimo, this.dataInicial, this.dataFinal, this.cliente, this.livros);
    }

    public EmprestimoDto fromEmprestimo(Emprestimo emprestimo){
        return new EmprestimoDto(
                emprestimo.getIdEmprestimo(),
                emprestimo.getDataInicial(),
                emprestimo.getDataFinal(),
                emprestimo.getLivros());
    }


    public EmprestimoDto() {
    }

    public EmprestimoDto(Long idEmprestimo, Date dataInicial, Date dataFinal, List<Livro> livros) {
        this.idEmprestimo = idEmprestimo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.livros = livros;
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
