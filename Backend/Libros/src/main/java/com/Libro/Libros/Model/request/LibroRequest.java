package com.Libro.Libros.Model.request;

import lombok.Data;

@Data
public class LibroRequest {
    private String titulo;
    private String isbn;
    private int anno_publicacion;
    private String descripcion;
}
