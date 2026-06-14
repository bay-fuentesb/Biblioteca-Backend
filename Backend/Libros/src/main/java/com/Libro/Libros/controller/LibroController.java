package com.Libro.Libros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.Libro.Libros.Model.entities.Libro;
import com.Libro.Libros.Model.request.LibroActualizarRequest;
import com.Libro.Libros.Model.request.LibroRequest;
import com.Libro.Libros.service.LibroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros") // <-- Todos los endpoints de este controlador empezarán con /libros
public class LibroController { // <-- OJO: Sin "extends BaseController" para evitar errores

    @Autowired
    private LibroService libroService;

 
    @GetMapping("")
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodosLibros();
    }


    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable("id") int id) {
        Libro libro = libroService.obtenerLibroPorId(id);
        if (libro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado con ID: " + id);
        }
        return libro;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro agregar(@RequestBody LibroRequest libroNuevo) {
        return libroService.AgregarLibro(libroNuevo);
    }

 
    @PutMapping("")
    public Libro actualizar(@RequestBody LibroActualizarRequest libroEditado) {
        return libroService.actualizaLibro(libroEditado);
    }

   
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") int id) {
        return libroService.eliminarLibro(id);
    }
}