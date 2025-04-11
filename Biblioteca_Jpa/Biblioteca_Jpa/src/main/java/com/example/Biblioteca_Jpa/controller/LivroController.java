package com.example.Biblioteca_Jpa.controller;

import com.example.Biblioteca_Jpa.dto.EmprestimoDto;
import com.example.Biblioteca_Jpa.dto.LivroDto;
import com.example.Biblioteca_Jpa.entity.Emprestimo;
import com.example.Biblioteca_Jpa.entity.Livro;
import com.example.Biblioteca_Jpa.service.EmprestimoService;
import com.example.Biblioteca_Jpa.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAll(){
        return livroService.getAllLivro();
    }

    @GetMapping("/{idLivro}")
    public ResponseEntity<LivroDto> getById(@PathVariable Long idLivro){
        Optional<LivroDto> livroDtoOptional = livroService.getById(idLivro);
        if (livroDtoOptional.isPresent()){
            return ResponseEntity.ok(livroDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LivroDto> create(@RequestBody LivroDto livroDto){
        LivroDto livroDtoSave = livroService.createLivro(livroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroDtoSave);
    }

    @PutMapping("/{idLivro}")
    public ResponseEntity<LivroDto> updateLivro(@PathVariable Long idLivro, @RequestBody LivroDto livroDto){
        Optional<LivroDto> livroDtoOptional = livroService.updateLivro(idLivro, livroDto);
        if (livroDtoOptional.isPresent()){
            return ResponseEntity.ok(livroDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idLivro}")
    public ResponseEntity<Void> delete(@PathVariable Long idLivro){
        if (livroService.deleteLivro(idLivro)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
