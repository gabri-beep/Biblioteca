package com.example.Biblioteca_Jpa.repository;

import com.example.Biblioteca_Jpa.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
