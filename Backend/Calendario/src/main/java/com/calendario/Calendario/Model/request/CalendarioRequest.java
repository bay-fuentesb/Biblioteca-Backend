package com.calendario.Calendario.Model.request;

import lombok.Data;

@Data
public class CalendarioRequest {
    private String fecha_exacta;
    private String motivo;
    private String hora_inicio;
}
