package com.calendario.Calendario.Model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CALENDARIO")
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_calendario;

    @Column(nullable = false)
    private String fecha_exacta;

    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private String hora_inicio;
}
