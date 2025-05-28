package com.nortebar.api.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record FuncionariosDTO (

    @NotBlank 
    String nome, 

    @NotBlank 
    String cargo,

    @DecimalMin("0") 
    BigDecimal salario
){}