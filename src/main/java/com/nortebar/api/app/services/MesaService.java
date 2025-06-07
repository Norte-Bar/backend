package com.nortebar.api.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortebar.api.app.repositories.MesaRepository;
import com.nortebar.api.models.dtos.MesaDTO;
import com.nortebar.api.models.entities.Mesa;

@Service
public class MesaService {
    
    final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }

    public Mesa create(MesaDTO dto) {
        return mesaRepository.save(new Mesa(dto));
    }
}
