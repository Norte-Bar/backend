package com.nortebar.api.models.dtos;

import java.util.List;

import com.nortebar.api.commons.enums.StatusPedido;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PedidoDTO(
    @NotNull(message = "O ID da mesa é obrigatório")
    Integer mesa_id,

    @NotNull(message = "O ID do funcionário é obrigatório")
    Integer funcionario_id,

    @NotNull(message = "O status é obrigatório")
    StatusPedido status,
    
    @NotEmpty(message = "A lista de comidas não pode ser vazia")
    List<@NotNull(message = "ID da comida não pode ser nulo") Integer> comidas
) {}


