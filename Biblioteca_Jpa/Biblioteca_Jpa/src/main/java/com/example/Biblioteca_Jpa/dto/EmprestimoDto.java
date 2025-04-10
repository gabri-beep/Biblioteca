package com.example.Biblioteca_Jpa.dto;

import com.example.Biblioteca_Jpa.entity.Emprestimo;

import java.util.Date;

public class EmprestimoDto {
    private Long idEmprestimo;
    private Date dataInicial;
    private Date dataFinal;

    public Emprestimo toEmprestimo(){
        return new Emprestimo(
                this.idEmprestimo,
                this.dataInicial,
                this.dataFinal);
    }

    public EmprestimoDto fromEmprestimo(Emprestimo emprestimo){
        return new EmprestimoDto(
                emprestimo.getIdEmprestimo(),
                emprestimo.getDataInicial(),
                emprestimo.getDataFinal());
    }


    public EmprestimoDto() {
    }

    public EmprestimoDto(Long idEmprestimo, Date dataInicial, Date dataFinal) {
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
