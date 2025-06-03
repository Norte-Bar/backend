package com.nortebar.api.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nortebar.api.app.services.ReservaService;
import com.nortebar.api.models.dtos.ReservaDTO;
import com.nortebar.api.models.entities.Reserva;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @PostMapping
    public Reserva create(@RequestBody @Valid ReservaDTO body) {
        return reservaService.create(body);
    }
}
