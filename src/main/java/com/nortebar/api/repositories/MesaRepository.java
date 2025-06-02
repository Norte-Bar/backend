package com.nortebar.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortebar.api.models.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    
}
