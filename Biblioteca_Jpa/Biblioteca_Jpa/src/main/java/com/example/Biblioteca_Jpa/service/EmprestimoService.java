package com.example.Biblioteca_Jpa.service;

import com.example.Biblioteca_Jpa.dto.ClienteDto;
import com.example.Biblioteca_Jpa.dto.EmprestimoDto;
import com.example.Biblioteca_Jpa.entity.Cliente;
import com.example.Biblioteca_Jpa.entity.Emprestimo;
import com.example.Biblioteca_Jpa.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;


    //buscar todos os emprestimos
    public List<Emprestimo> getAllEmprestimo(){
        return emprestimoRepository.findAll();
    }

    //buscar clientes pelo id
    public Optional<EmprestimoDto> getById(Long idEmprestimo){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(idEmprestimo);
        if (emprestimoOptional.isPresent()){
            EmprestimoDto emprestimoDto = new EmprestimoDto();
            return Optional.of(emprestimoDto.fromEmprestimo(emprestimoOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    //post de cliente
    public EmprestimoDto createEmprestimo(EmprestimoDto emprestimoDto){
        Emprestimo emprestimo = emprestimoDto.toEmprestimo();
        emprestimo = emprestimoRepository.save(emprestimo);
        return emprestimoDto.fromEmprestimo(emprestimo);
    }

    // update cliente
    public Optional<EmprestimoDto> updateEmprestimo(Long idEmprestimo, EmprestimoDto emprestimoDto){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(idEmprestimo);
        if (emprestimoOptional.isPresent()){
            Emprestimo emprestimo = emprestimoOptional.get();
            emprestimo.setIdEmprestimo(emprestimoDto.getIdEmprestimo());
            emprestimo.setDataInicial(emprestimoDto.getDataInicial());
            emprestimo.setDataFinal(emprestimoDto.getDataFinal());

            emprestimo = emprestimoRepository.save(emprestimo);

            return Optional.of(emprestimoDto.fromEmprestimo(emprestimo));
        } else {
            return Optional.empty();
        }
    }

    //deletar emprestimo
    public boolean deleteEmprestimo(Long idEmprestimo){
        if (emprestimoRepository.existsById(idEmprestimo)){
            emprestimoRepository.deleteById(idEmprestimo);
            return true;
        } else {
            return false;
        }
    }
}
