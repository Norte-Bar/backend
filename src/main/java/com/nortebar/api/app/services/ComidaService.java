package com.nortebar.api.app.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nortebar.api.app.repositories.ComidaRepository;
import com.nortebar.api.models.dtos.ComidaDTO;
import com.nortebar.api.models.entities.Comida;

@Service
public class ComidaService {

    final ComidaRepository comidaRepository;

    public ComidaService(ComidaRepository comidaRepository){
        this.comidaRepository = comidaRepository;
    }

    public List<Comida> findAll() {
        return comidaRepository.findAll();
    }
    
    public Comida create(ComidaDTO dto) {

        if(!StringUtils.hasText(dto.nome())){
            throw new IllegalArgumentException("Nome e obrigatorio!");
        }
        if(!StringUtils.hasText(dto.tipo())) {
            throw new IllegalArgumentException("Tipo é obrigatório");
        } 
        if (dto.preco().compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        return comidaRepository.save(new Comida(dto));
    }

    public Comida update(Integer id, Comida novaComida) {
        return comidaRepository.findById(id).map(comida -> {
            comida.setNome(novaComida.getNome());
            comida.setDescricao(novaComida.getDescricao());
            comida.setPreco(novaComida.getPreco());
            comida.setTipo(novaComida.getTipo());
            comida.setStatus(novaComida.getStatus());
            return comidaRepository.save(comida);
        }).orElseThrow(() -> new RuntimeException("Comida não encontrada!"));
    }

    public void delete(Integer id) {
        if(!comidaRepository.existsById(id)) {
            throw new RuntimeException("Comida não encontrada!");
        }
        comidaRepository.deleteById(id);
    }
}