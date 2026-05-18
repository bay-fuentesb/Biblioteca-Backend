package com.Libro.Libros.Model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LibroActualizarRequest {
    @NotBlank(message = "El ID del libro es obligatorio")
    private Integer id_libro;
    @NotBlank(message = "El título del libro es obligatorio")
    private String titulo;
    @NotBlank(message = "El ISBN del libro es obligatorio")
    private String isbn;
    @NotBlank(message = "El año de publicación del libro es obligatorio")
    private int anno_publicacion;
    @NotBlank(message = "La descripción del libro es obligatoria")
    private String descripcion;
}