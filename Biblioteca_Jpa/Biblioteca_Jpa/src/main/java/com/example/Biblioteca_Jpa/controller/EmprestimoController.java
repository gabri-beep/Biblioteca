package com.example.Biblioteca_Jpa.controller;

import com.example.Biblioteca_Jpa.dto.ClienteDto;
import com.example.Biblioteca_Jpa.dto.EmprestimoDto;
import com.example.Biblioteca_Jpa.entity.Cliente;
import com.example.Biblioteca_Jpa.entity.Emprestimo;
import com.example.Biblioteca_Jpa.service.ClienteService;
import com.example.Biblioteca_Jpa.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> getAll(){
        return emprestimoService.getAllEmprestimo();
    }

    @GetMapping("/{idEmprestimo}")
    public ResponseEntity<EmprestimoDto> getById(@PathVariable Long idEmprestimo){
        Optional<EmprestimoDto> emprestimoDtoOptional = emprestimoService.getById(idEmprestimo);
        if (emprestimoDtoOptional.isPresent()){
            return ResponseEntity.ok(emprestimoDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmprestimoDto> create(@RequestBody EmprestimoDto emprestimoDto){
        EmprestimoDto emprestimoDtoSave = emprestimoService.createEmprestimo(emprestimoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoDtoSave);
    }

    @PutMapping("/{idEmprestimo}")
    public ResponseEntity<EmprestimoDto> updateEmprestimo(@PathVariable Long idEmprestimo, @RequestBody EmprestimoDto emprestimoDto){
        Optional<EmprestimoDto> emprestimoDtoOptional = emprestimoService.updateEmprestimo(idEmprestimo, emprestimoDto);
        if (emprestimoDtoOptional.isPresent()){
            return ResponseEntity.ok(emprestimoDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEmprestimo}")
    public ResponseEntity<Void> delete(@PathVariable Long idEmprestimo){
        if (emprestimoService.deleteEmprestimo(idEmprestimo)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
