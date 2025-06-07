package com.nortebar.api.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortebar.api.app.repositories.ReservaRepository;
import com.nortebar.api.models.dtos.ReservaDTO;
import com.nortebar.api.models.entities.Reserva;

@Service
public class ReservaService {
    final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva create(ReservaDTO dto) {
        return reservaRepository.save(new Reserva(dto));
    }
}
