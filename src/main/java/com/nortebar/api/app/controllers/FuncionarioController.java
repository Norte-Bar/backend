package com.nortebar.api.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nortebar.api.app.services.FuncionarioService;
import com.nortebar.api.models.dtos.FuncionariosDTO;
import com.nortebar.api.models.entities.Funcionario;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }

    @PostMapping
    public Funcionario create(@RequestBody @Valid FuncionariosDTO body) {
        return funcionarioService.create(body);
    }
}
