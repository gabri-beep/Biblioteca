package com.example.Biblioteca_Jpa.service;

import com.example.Biblioteca_Jpa.dto.LivroDto;
import com.example.Biblioteca_Jpa.entity.Cliente;
import com.example.Biblioteca_Jpa.entity.Livro;
import com.example.Biblioteca_Jpa.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;


    //buscar todos os livros
    public List<Livro> getAllLivro(){
        return livroRepository.findAll();
    }

    //buscar livros pelo id
    public Optional<LivroDto> getById(Long idLivro){
        Optional<Livro> livroOptional = livroRepository.findById(idLivro);
        if (livroOptional.isPresent()){
            LivroDto livroDto = new LivroDto();
            return Optional.of(livroDto.fromLivro(livroOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    //post de livro
    public LivroDto createLivro(LivroDto livroDto){
        Livro livro = livroDto.toLivro();
        livro = livroRepository.save(livro);
        return livroDto.fromLivro(livro);
    }

    // update livro
    public Optional<LivroDto> updateLivro(Long idLivro, LivroDto livroDto){
        Optional<Livro> livroOptional = livroRepository.findById(idLivro);
        if (livroOptional.isPresent()){
            Livro livro = livroOptional.get();
            livro.setIdLivro(livroDto.getIdLivro());
            livro.setNome(livroDto.getNome());
            livro.setAutor(livroDto.getAutor());
            livro.setIsbn(livroDto.getIsbn());
            livro.setGenero(livroDto.getGenero());

            livro = livroRepository.save(livro);

            return Optional.of(livroDto.fromLivro(livro));
        } else {
            return Optional.empty();
        }
    }

    //deletar livro
    public boolean deleteLivro(Long idLivro){
        if (livroRepository.existsById(idLivro)){
            livroRepository.deleteById(idLivro);
            return true;
        } else {
            return false;
        }
    }
}
