package com.nortebar.api.models.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record ReservaDTO (

    @NotBlank
    String cliente_nome,

    @NotBlank
    Integer numero_pessoas,

    @NotBlank
    LocalDateTime data_reserva,

    @NotBlank
    Boolean status_reserva
){}
