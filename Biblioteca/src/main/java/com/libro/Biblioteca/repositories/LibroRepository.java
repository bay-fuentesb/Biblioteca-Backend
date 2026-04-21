package com.libro.Biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libro.Biblioteca.Model.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
}
