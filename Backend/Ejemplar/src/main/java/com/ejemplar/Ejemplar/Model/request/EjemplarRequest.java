package com.ejemplar.Ejemplar.Model.request;

public class EjemplarRequest {
    private String codigo;
    private String estadoFisico;
    private String ubicacionFisica;

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
