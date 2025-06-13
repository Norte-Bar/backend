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

    public Reserva update(Integer id, Reserva novaReserva) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setCliente_nome(novaReserva.getCliente_nome());
            reserva.setNumero_pessoas(novaReserva.getNumero_pessoas());
            reserva.setData_reserva(novaReserva.getData_reserva());
            reserva.setStatus_reserva(novaReserva.getStatus_reserva());
            return reservaRepository.save(reserva);
        }).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
    }

    public void delete(Integer id) {
        if(!reservaRepository.existsById(id)) {
            throw new RuntimeException("Reserva não encontrada");
        }
        reservaRepository.deleteById(id);
    }
}
