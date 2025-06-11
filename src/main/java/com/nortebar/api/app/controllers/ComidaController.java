package com.nortebar.api.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nortebar.api.app.services.ComidaService;
import com.nortebar.api.models.dtos.ComidaDTO;
import com.nortebar.api.models.entities.Comida;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comida")
public class ComidaController {

    final ComidaService comidaService;

    public ComidaController(ComidaService comidaService){
        this.comidaService = comidaService;
    }

    @GetMapping
    public List<Comida> findAll() {
        return comidaService.findAll();       
    }

    @PostMapping
    public Comida create(@RequestBody @Valid ComidaDTO body) {
        return comidaService.create(body);
    }

}