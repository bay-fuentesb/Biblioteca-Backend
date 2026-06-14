package com.ejemplar.Ejemplar.Model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public String getCodigo_ejemplar() {
        return codigo_ejemplar;
    }

    public void setCodigo_ejemplar(String codigo_ejemplar) {
        this.codigo_ejemplar = codigo_ejemplar;
    }

    public String getEstado_fisico() {
        return estado_fisico;
    }

    public void setEstado_fisico(String estado_fisico) {
        this.estado_fisico = estado_fisico;
    }

    public String getUbicacion_fisica() {
        return ubicacion_fisica;
    }

    public void setUbicacion_fisica(String ubicacion_fisica) {
        this.ubicacion_fisica = ubicacion_fisica;
    }
}
