package com.nortebar.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortebar.api.models.entities.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    
}
