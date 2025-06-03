package com.nortebar.api.app.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nortebar.api.app.repositories.FuncionarioRepository;
import com.nortebar.api.models.dtos.FuncionariosDTO;
import com.nortebar.api.models.entities.Funcionario;

@Service
public class FuncionarioService {

    final PasswordEncoder passwordEncoder;
    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(PasswordEncoder passwordEncoder, FuncionarioRepository funcionarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario create(FuncionariosDTO dto) {
        Funcionario funcionario = new Funcionario(dto);
        String senhaCriptografada = passwordEncoder.encode(dto.senha());
        funcionario.setSenha(senhaCriptografada);
        return funcionarioRepository.save(funcionario);
    }

}
