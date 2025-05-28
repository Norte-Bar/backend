package com.nortebar.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortebar.api.dtos.FuncionariosDTO;
import com.nortebar.api.models.Funcionario;
import com.nortebar.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario create(FuncionariosDTO dto) {
        return funcionarioRepository.save(new Funcionario(dto));
    }

}
