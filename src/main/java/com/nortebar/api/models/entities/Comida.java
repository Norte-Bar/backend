package com.nortebar.api.models.entities;

import java.math.BigDecimal;

import com.nortebar.api.models.dtos.ComidaDTO;

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
@Table(name = "comida")
public class Comida {

    public Comida(ComidaDTO dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.preco = dto.preco();
        this.tipo = dto.tipo();
        this.status = dto.status();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(length = 50, nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Boolean status;
}
