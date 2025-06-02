package com.nortebar.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record MesaDTO(

    @NotBlank
    Integer numero,

    @NotBlank
    Integer capacidade
) {}
