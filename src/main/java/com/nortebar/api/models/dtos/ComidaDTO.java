package com.nortebar.api.models.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ComidaDTO(

    @NotBlank
    String nome,

    @NotBlank
    String descricao,

    @NotNull(message = "O preço é obrigatório")
    BigDecimal preco,

    @NotBlank
    String tipo,

    @NotNull
    Boolean status
) {}
