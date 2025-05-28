package com.nortebar.api.models;

import java.math.BigDecimal;

import com.nortebar.api.dtos.FuncionariosDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

    public Funcionario(FuncionariosDTO dto) {
        this.nome = dto.nome();
        this.cargo = dto.cargo();
        this.salario = dto.salario();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private String cargo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;
}
