package com.nortebar.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortebar.api.dtos.MesaDTO;
import com.nortebar.api.models.Mesa;
import com.nortebar.api.repositories.MesaRepository;

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
