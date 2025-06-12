package com.nortebar.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nortebar.api.models.entities.ComidasPedido;

import jakarta.transaction.Transactional;

public interface ComidasPedidoRepository extends JpaRepository<ComidasPedido, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM ComidasPedido cp WHERE cp.pedido.id = :pedidoId")
    void deleteByPedidoId(@Param("pedidoId") Integer pedidoId);
}
