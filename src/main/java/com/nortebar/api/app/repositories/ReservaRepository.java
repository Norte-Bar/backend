package com.nortebar.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortebar.api.models.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
}
