package com.reserva.Reserva.Model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "RESERVA")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Reserva;

    @Column(nullable = false)
    Private String fecha_reserva;

    @Column(nullable = false)
    private String estado_reserva;
}
