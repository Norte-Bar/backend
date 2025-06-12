package com.nortebar.api.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nortebar.api.app.services.PedidoService;
import com.nortebar.api.models.dtos.PedidoDTO;
import com.nortebar.api.models.dtos.PedidoResponseDTO;
import com.nortebar.api.models.entities.Pedido;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoResponseDTO> findAll() {
        return pedidoService.findAll();
    }

    @PostMapping
    public Pedido create(@RequestBody @Valid PedidoDTO body) {
        return pedidoService.create(body);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable Integer id, @RequestBody PedidoDTO pedido) {
        return pedidoService.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pedidoService.delete(id);
    }
}
