package com.nortebar.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortebar.api.models.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
