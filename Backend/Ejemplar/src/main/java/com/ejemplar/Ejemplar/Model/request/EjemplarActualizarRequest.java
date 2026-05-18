package com.ejemplar.Ejemplar.Model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EjemplarActualizarRequest {
    @NotBlank(message = "El id del ejemplar no puede estar vacío")
    private int id_ejemplar;
    @NotBlank(message = "El código del ejemplar no puede estar vacío")
    private String codigo;
    @NotBlank(message = "El estado físico del ejemplar no puede estar vacío")
    private String estadoFisico;
    @NotBlank(message = "La ubicación física del ejemplar no puede estar vacía")
    private String ubicacionFisica;
}
