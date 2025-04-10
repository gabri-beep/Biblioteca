package com.example.Biblioteca_Jpa.repository;

import com.example.Biblioteca_Jpa.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
