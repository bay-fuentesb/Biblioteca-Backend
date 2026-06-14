package com.ejemplar.Ejemplar.Model.request;

import jakarta.validation.constraints.NotBlank;

public class EjemplarActualizarRequest {
    @NotBlank(message = "El id del ejemplar no puede estar vacío")
    private int id_ejemplar;
    @NotBlank(message = "El código del ejemplar no puede estar vacío")
    private String codigo;
    @NotBlank(message = "El estado físico del ejemplar no puede estar vacío")
    private String estadoFisico;
    @NotBlank(message = "La ubicación física del ejemplar no puede estar vacía")
    private String ubicacionFisica;

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public String getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(String ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }
}
