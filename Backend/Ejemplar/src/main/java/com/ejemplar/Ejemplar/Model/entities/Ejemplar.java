package com.ejemplar.Ejemplar.Model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EJEMPLAR")
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ejemplar;

    @Column(nullable = false)
    private String codigo_ejemplar;
    
    @Column(nullable = false)
    private String estado_fisico;

    @Column(nullable = false)
    private String ubicacion_fisica;
}
