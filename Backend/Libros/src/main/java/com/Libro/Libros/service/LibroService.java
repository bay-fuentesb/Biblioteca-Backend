package com.Libro.Libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libro.Libros.repositories.LibroRepository;
import com.Libro.Libros.Model.entities.Libro;


@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepo;

    public Libro obtenerLibroPorId(int id_libro){
        return libroRepo.findById(id_libro).orElse(null);
    }

    public List<Libro> ObtenerLibros() {
        return libroRepo.findAll();
    }

}
