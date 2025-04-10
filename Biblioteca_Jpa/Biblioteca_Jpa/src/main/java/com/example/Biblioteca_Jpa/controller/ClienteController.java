package com.example.Biblioteca_Jpa.controller;

import com.example.Biblioteca_Jpa.dto.ClienteDto;
import com.example.Biblioteca_Jpa.entity.Cliente;
import com.example.Biblioteca_Jpa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getAllCliente();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDto> getById(@PathVariable Long idCliente){
        Optional<ClienteDto> clienteDtoOptional = clienteService.getById(idCliente);
        if (clienteDtoOptional.isPresent()){
            return ResponseEntity.ok(clienteDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto clienteDto){
        ClienteDto clienteDtoSave = clienteService.createCliente(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDtoSave);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable Long idCliente, @RequestBody ClienteDto clienteDto){
        Optional<ClienteDto> clienteDtoOptional = clienteService.updateCliente(idCliente, clienteDto);
        if (clienteDtoOptional.isPresent()){
            return ResponseEntity.ok(clienteDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> delete(@PathVariable Long idCliente){
        if (clienteService.deleteCliente(idCliente)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
