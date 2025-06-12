package com.nortebar.api.models.dtos;

import java.util.List;

import com.nortebar.api.commons.enums.StatusPedido;
import com.nortebar.api.models.entities.Comida;
import com.nortebar.api.models.entities.Funcionario;
import com.nortebar.api.models.entities.Mesa;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoResponseDTO {
    private Integer id;
    private StatusPedido status;
    private Funcionario funcionario;
    private Mesa mesa;
    private List<Comida> comidas;
}
