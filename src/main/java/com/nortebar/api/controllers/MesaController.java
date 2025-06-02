package com.nortebar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nortebar.api.dtos.MesaDTO;
import com.nortebar.api.models.Mesa;
import com.nortebar.api.services.MesaService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
public class MesaController {
    
    final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public List<Mesa> findAll() {
        return mesaService.findAll();
    }

    @PostMapping
    public Mesa create(@RequestBody @Valid MesaDTO body) {
        return mesaService.create(body);
    }

}
