package com.multa.Multa.Model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MultaActualizadoRequest {
    @NotBlank(message = "El ID de la multa no puede estar vacío")
    private int idMulta;
    @NotBlank(message = "El motivo de la multa no puede estar vacío")
    private String motivoMulta;
    @NotBlank(message = "El monto de la multa no puede estar vacío")
    private double montoMulta; 
    @NotBlank(message = "La fecha de emisión de la multa no puede estar vacía")
    private String fechaEmision;
    @NotBlank(message = "El estado de la multa no puede estar vacío")
    private String estadoMulta;
}
