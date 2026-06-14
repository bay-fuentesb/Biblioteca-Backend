package com.anuncio.Anuncio.Model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Anuncio")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_anuncio;

    @Column(name = "fecha_exacta", nullable = false)
    private String fechaExacta;

    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private String hora_inicio;
}
