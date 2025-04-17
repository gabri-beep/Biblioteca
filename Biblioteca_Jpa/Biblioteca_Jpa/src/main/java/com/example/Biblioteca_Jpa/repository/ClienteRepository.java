package com.example.Biblioteca_Jpa.repository;

import com.example.Biblioteca_Jpa.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByNome(String nome);
}
