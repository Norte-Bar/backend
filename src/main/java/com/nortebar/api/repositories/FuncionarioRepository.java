package com.nortebar.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortebar.api.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    
}
