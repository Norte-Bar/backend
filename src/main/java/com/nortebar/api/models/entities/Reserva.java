package com.nortebar.api.models.entities;

import java.time.LocalDateTime;

import com.nortebar.api.models.dtos.ReservaDTO;

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
@Table(name = "reserva")
public class Reserva {
    
    public Reserva(ReservaDTO dto) {
        this.cliente_nome = dto.cliente_nome();
        this.numero_pessoas = dto.numero_pessoas();
        this.data_reserva = dto.data_reserva();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String cliente_nome;

    @Column(nullable = false)
    private Integer numero_pessoas;

    @Column(nullable = false)
    private LocalDateTime data_reserva;

    @Column(nullable = false)
    private Boolean status_reserva;
}
