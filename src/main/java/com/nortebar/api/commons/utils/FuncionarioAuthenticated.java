package com.nortebar.api.commons.utils;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nortebar.api.models.entities.Funcionario;

public class FuncionarioAuthenticated implements UserDetails{

    private final Funcionario funcionario;

    public FuncionarioAuthenticated(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> funcionario.getCargo());
    }

    @Override
    public String getPassword() {
        return funcionario.getSenha();
    }

    @Override
    public String getUsername() {
        return funcionario.getNome();
    }
    
}
