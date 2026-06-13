package com.anuncio.Anuncio.Model.request;

import lombok.Data;

@Data
public class AnuncioRequest {
    private String fecha_exacta;
    private String motivo;
    private String hora_inicio;
}
