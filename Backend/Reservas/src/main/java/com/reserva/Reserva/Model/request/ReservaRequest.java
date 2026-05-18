package com.reserva.Reserva.Model.request;

import lombok.Data;

@Data
public class ReservaRequest {
    private int id_Reserva;
    private String fecha_reserva;
    private String estado_reserva;
}
