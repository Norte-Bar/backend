package com.nortebar.api.commons.utils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nortebar.api.app.repositories.FuncionarioRepository;

@Service
public class FuncionarioDetailsService implements UserDetailsService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioDetailsService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return funcionarioRepository.findByNome(username)
            .map(FuncionarioAuthenticated::new)
            .orElseThrow(() -> new UsernameNotFoundException("Funcionario não encontrado!"));
    }
    
}
