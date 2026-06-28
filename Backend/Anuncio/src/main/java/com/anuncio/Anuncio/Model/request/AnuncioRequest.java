package com.anuncio.Anuncio.Model.request;

import lombok.Data;

@Data
public class AnuncioRequest {
    private int id_anuncio;
    private String fecha_exacta;
    private String motivo;
    private String hora_inicio;
}
