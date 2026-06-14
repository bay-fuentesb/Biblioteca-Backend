package com.multa.Multa.Model.request;

import lombok.Data;

@Data
public class MultaRequest {
    private int idMulta;
    private int idUsuario;
    private String motivoMulta;
    private double montoMulta;
    private String fechaEmision;
    private String estadoMulta;
}
