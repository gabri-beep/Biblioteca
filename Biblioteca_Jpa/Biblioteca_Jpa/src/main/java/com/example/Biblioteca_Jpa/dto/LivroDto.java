package com.example.Biblioteca_Jpa.dto;

import com.example.Biblioteca_Jpa.entity.Livro;
import jakarta.persistence.Column;

public class LivroDto {
    private Long idLivro;
    private String nome;
    private String autor;
    @Column(unique = true)
    private String isbn;
    private String genero;

    public Livro toLivro(){
        return new Livro(
                this.idLivro,
                this.nome,
                this.autor,
                this.isbn,
                this.genero
        );
    }

    public LivroDto fromLivro(Livro livro){
        return new LivroDto(
                livro.getIdLivro(),
                livro.getNome(),
                livro.getAutor(),
                livro.getIsbn(),
                livro.getGenero()
        );
    }

    public LivroDto() {
    }

    public LivroDto(Long idLivro, String nome, String autor, String isbn, String genero) {
        this.idLivro = idLivro;
        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
