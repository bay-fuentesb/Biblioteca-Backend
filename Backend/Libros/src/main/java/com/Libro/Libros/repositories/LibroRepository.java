package com.Libro.Libros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Libro.Libros.Model.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
}
