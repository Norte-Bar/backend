package com.nortebar.api.models.entities;

import java.time.LocalDateTime;

import com.nortebar.api.models.dtos.FeedbackDTO;

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
@Table(name = "feedback")
public class Feedback {
    
    public Feedback(FeedbackDTO dto) {
        this.comentario = dto.comentario();
        this.data = dto.data();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 500, nullable = false)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime data;

}
