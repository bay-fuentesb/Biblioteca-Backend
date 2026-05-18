package com.reserva.Reserva.Model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReservaActualizadoRequest {
    @NotBlank(message = "El ID de la reserva es obligatorio")
    private int id_Reserva;
    @NotBlank(message = "La fecha de reserva es obligatoria")
    private String fecha_reserva;
    @NotBlank(message = "El estado de la reserva es obligatorio")
    private String estado_reserva;
}
