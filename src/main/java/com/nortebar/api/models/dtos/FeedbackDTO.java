package com.nortebar.api.models.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record FeedbackDTO(

    @NotBlank
    String comentario,

    @NotBlank
    LocalDateTime data

){}
