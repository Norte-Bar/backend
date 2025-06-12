package com.nortebar.api.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nortebar.api.commons.enums.StatusPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @Column(nullable = false)
    // private Integer funcionario_id;

    // @Column(nullable = false)
    // private Integer mesa_id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ComidasPedido> comidasPedido;
}
