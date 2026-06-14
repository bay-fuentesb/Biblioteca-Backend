package com.multa.Multa.Model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "Multa_Sancion")
public class Multas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_multa")
    private Integer idMulta;

    @Column(name = "id_usuario" , nullable = true)
    private Integer idUsuario;

    @Column(name = "motivo",nullable = false, length = 255)
    private String motivo;

    @Column(name = "monto",nullable = false)
    private Double monto;

    @Column(name = "fecha_emision",nullable = false)
    private String fechaEmision;

    @Column(name = "estado",length = 50)
    private String estado;

 
}