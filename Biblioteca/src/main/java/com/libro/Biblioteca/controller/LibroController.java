package com.libro.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libro.Biblioteca.Model.entities.Libro;
import com.libro.Biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;



@RequestMapping("/libro")
@RestController
public class LibroController {
    

    @Autowired
    private LibroService libroService;

    @GetMapping("")
    public List<Libro> ObtenerLibros() {
        return libroService.ObtenerLibros();
    }
}
