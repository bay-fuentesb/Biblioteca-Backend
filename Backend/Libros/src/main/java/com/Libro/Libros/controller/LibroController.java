package com.Libro.Libros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Libro.Libros.Model.entities.Libro;
import com.Libro.Libros.Model.request.LibroActualizarRequest;
import com.Libro.Libros.Model.request.LibroRequest;
import com.Libro.Libros.service.LibroService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/libro")
@RestController
public class LibroController {
    
    @Autowired
    private LibroService libroService;

   
    @GetMapping("")
    public List<Libro> obtenerTodosLibros() {
        return libroService.obtenerTodosLibros();
    }


    @GetMapping("/{idLibro}")
    public Libro obtenerLibroPorId(@PathVariable int idLibro) {
        return libroService.obtenerLibroPorId(idLibro);
    }

  
    @PostMapping("")
    public Libro crearLibro(@Valid @RequestBody LibroRequest libroRequest) {
        return libroService.crearLibro(libroRequest);
    }

    @PutMapping("")
    public Libro actualizarLibro(@Valid @RequestBody LibroActualizarRequest libroActualizarRequest) {
        return libroService.actualizarLibro(libroActualizarRequest);
    }

    @DeleteMapping("/{idLibro}")
    public String eliminarLibro(@PathVariable int idLibro) {
        return libroService.eliminarLibro(idLibro);
    }
}