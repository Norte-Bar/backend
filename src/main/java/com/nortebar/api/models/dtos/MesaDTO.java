package com.nortebar.api.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MesaDTO(

    @NotNull(message = "O número da mesa é obrigatório")
    @Min(value = 1, message = "O número da mesa deve ser maior que zero")
    Integer numero,

    @NotNull(message = "A capacidade da mesa é obrigatório")
    @Min(value = 1, message = "A capacidade da mesa deve ser maior que zero")
    Integer capacidade
) {}
