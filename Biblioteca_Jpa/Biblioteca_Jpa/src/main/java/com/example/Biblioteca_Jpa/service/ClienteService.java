package com.example.Biblioteca_Jpa.service;

import com.example.Biblioteca_Jpa.dto.ClienteDto;
import com.example.Biblioteca_Jpa.entity.Cliente;
import com.example.Biblioteca_Jpa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    //buscar todos os clientes
    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }

    //buscar clientes pelo id
    public Optional<ClienteDto> getById(Long idCliente){
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        if (clienteOptional.isPresent()){
            ClienteDto clienteDto = new ClienteDto();
            return Optional.of(clienteDto.fromCliente(clienteOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    //post de cliente
    public ClienteDto createCliente(ClienteDto clienteDto){
        Cliente cliente = clienteDto.toCliente();
        cliente = clienteRepository.save(cliente);
        return clienteDto.fromCliente(cliente);
    }

    // update cliente
    public Optional<ClienteDto> updateCliente(Long idCliente, ClienteDto clienteDto){
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        if (clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setIdCliente(clienteDto.getIdCliente());
            cliente.setNome(clienteDto.getNome());
            cliente.setSobrenome(clienteDto.getSobrenome());
            cliente.setCpf(clienteDto.getCpf());

            cliente = clienteRepository.save(cliente);

            return Optional.of(clienteDto.fromCliente(cliente));
        } else {
            return Optional.empty();
        }
    }

    //deletar cliente
    public boolean deleteCliente(Long idCliente){
        if (clienteRepository.existsById(idCliente)){
            clienteRepository.deleteById(idCliente);
            return true;
        } else {
            return false;
        }
    }
}