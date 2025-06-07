package com.nortebar.api.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record MesaDTO(

    @NotBlank
    Integer numero,

    @NotBlank
    Integer capacidade
) {}
