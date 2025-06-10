package com.nortebar.api.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nortebar.api.app.services.MesaService;
import com.nortebar.api.models.dtos.MesaDTO;
import com.nortebar.api.models.entities.Mesa;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mesa")
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

    @PutMapping("/{id}")
    public Mesa update(@PathVariable Integer id, @RequestBody Mesa mesa) {
        return mesaService.update(id, mesa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        mesaService.delete(id);
    }

}
