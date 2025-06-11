package com.nortebar.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortebar.api.models.entities.Comida;

public interface ComidaRepository extends JpaRepository<Comida, Integer>{
    
}
