package com.libro.Biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libro.Biblioteca.Model.entities.Libro;
import com.libro.Biblioteca.repositories.LibroRepository;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepo;

    public List<Libro> ObtenerLibros() {
        return libroRepo.findAll();
    }



}
