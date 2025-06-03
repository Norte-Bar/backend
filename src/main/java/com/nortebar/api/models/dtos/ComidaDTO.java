package com.nortebar.api.models.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record ComidaDTO(

    @NotBlank
    String nome,

    @NotBlank
    String descricao,

    @NotBlank
    BigDecimal preco,

    @NotBlank
    String tipo,

    @NotBlank
    Boolean status
) {}
