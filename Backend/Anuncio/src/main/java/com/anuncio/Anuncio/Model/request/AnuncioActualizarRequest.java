package com.anuncio.Anuncio.Model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AnuncioActualizarRequest {
    @NotBlank(message = "El campo id_anuncioio no puede estar vacío")
    private int id_anuncio;
    @NotBlank(message = "El campo Fecha_exacta no puede estar vacío")
    private String Fecha_exacta;
    @NotBlank(message = "El campo motivo no puede estar vacío")
    private String motivo;
    @NotBlank(message = "El campo hora_inicio no puede estar vacío")
    private String hora_inicio;


}
